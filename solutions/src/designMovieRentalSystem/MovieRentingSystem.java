package designMovieRentalSystem;

import java.util.*;

public class MovieRentingSystem {

    private static class Pair<T, K> {
        T first;
        K second;

        public Pair(T first, K second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair<?, ?> pair = (Pair<?, ?>) o;

            if (!Objects.equals(first, pair.first)) return false;
            return Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }
    }

    private static class Triple<T, K, L> {
        T first;
        K second;
        L third;

        public Triple(T first, K second, L third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Triple<?, ?, ?> triple = (Triple<?, ?, ?>) o;

            if (!Objects.equals(first, triple.first)) return false;
            if (!Objects.equals(second, triple.second)) return false;
            return Objects.equals(third, triple.third);
        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            result = 31 * result + (third != null ? third.hashCode() : 0);
            return result;
        }
    }

    private final Map<Integer, TreeSet<Pair<Integer, Integer>>> movieHeap;
    private final TreeSet<Triple<Integer, Integer, Integer>> rented;

    private final Map<Long, Integer> price;


    public MovieRentingSystem(int n, int[][] entries) {
        this.movieHeap = new HashMap<>();
        this.price = new HashMap<>();
        this.rented = new TreeSet<>((p1, p2) -> {
            if (Objects.equals(p1.third, p2.third)) {
                if (Objects.equals(p1.first, p2.first)) {
                    return Integer.compare(p1.second, p2.second);
                } else {
                    return Integer.compare(p1.first, p2.first);
                }
            } else {
                return Integer.compare(p1.third, p2.third);
            }
        });
        for (int[] entry : entries) {
            int movie = entry[1];
            this.movieHeap.computeIfAbsent(movie, p -> new TreeSet<>((p1, p2) -> {
                if (Objects.equals(p1.second, p2.second)) {
                    return Integer.compare(p1.first, p2.first);
                } else {
                    return Integer.compare(p1.second, p2.second);
                }
            })).add(new Pair<>(entry[0], entry[2]));
            long key = ((long) entry[0] << 19) | entry[1];
            this.price.put(key, entry[2]);
        }
    }

    public List<Integer> search(int movie) {
        if (!this.movieHeap.containsKey(movie)) {
            return List.of();
        }
        List<Integer> answer = new ArrayList<>();
        int c = 0;
        for (var pair : this.movieHeap.get(movie)) {
            if (c == 5) {
                break;
            }
            answer.add(pair.first);
            c++;
        }
        return answer;
    }

    public void rent(int shop, int movie) {
        long key = ((long) shop << 19) | movie;
        this.movieHeap.get(movie).remove(new Pair<>(shop, this.price.get(key)));
        this.rented.add(new Triple<>(shop, movie, this.price.get(key)));
    }

    public void drop(int shop, int movie) {
        long key = ((long) shop << 19) | movie;
        this.rented.remove(new Triple<>(shop, movie, this.price.get(key)));
        this.movieHeap.get(movie).add(new Pair<>(shop, this.price.get(key)));
    }

    public List<List<Integer>> report() {
        List<List<Integer>> report = new ArrayList<>();
        int c = 0;
        for (var triple : this.rented) {
            if (c == 5) {
                break;
            }
            report.add(List.of(triple.first, triple.second));
            c++;
        }
        return report;
    }

}