package rewardTopKStudents;

import java.util.*;

public class RewardTopKStudents {

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> positive = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> negative = new HashSet<>(Arrays.asList(negative_feedback));
        PriorityQueue<Tuple> tuples = new PriorityQueue<>((p1, p2) -> {
            if (p1.points == p2.points) {
                return Integer.compare(p2.id, p1.id);
            } else {
                return Integer.compare(p1.points, p2.points);
            }
        });
        for (int i = 0; i < report.length; i++) {
            String[] wordsSplit = report[i].split(" ");
            int points = 0;
            for (String word : wordsSplit) {
                if (positive.contains(word)) {
                    points += 3;
                } else if (negative.contains(word)) {
                    points--;
                }
            }
            if (tuples.size() < k) {
                tuples.add(new Tuple(points, student_id[i]));
            } else {
                if (tuples.peek().points < points || tuples.peek().points == points && tuples.peek().id > student_id[i]) {
                    tuples.poll();
                    tuples.add(new Tuple(points, student_id[i]));
                }
            }
        }
        List<Integer> students = new ArrayList<>();
        while (!tuples.isEmpty()) {
            students.add(tuples.poll().id);
        }
        Collections.reverse(students);
        return students;
    }

    static class Tuple {

        public Tuple(int points, int id) {
            this.points = points;
            this.id = id;
        }

        int points;
        int id;
    }

}
