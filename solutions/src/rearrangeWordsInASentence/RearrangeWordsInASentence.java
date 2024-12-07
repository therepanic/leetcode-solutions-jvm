package rearrangeWordsInASentence;

import java.util.AbstractMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeWordsInASentence {
    public String arrangeWords(String text) {
        PriorityQueue<Map.Entry<Integer, String>> heap = new PriorityQueue<>((a, b) -> {
            if (a.getValue().length() > b.getValue().length()) {
                return 1;
            } else if (a.getValue().length() < b.getValue().length()) {
                return -1;
            } else {
                return a.getKey().compareTo(b.getKey());
            }
        });
        String[] strings = text.split(" ");

        for (int i = 0; i < strings.length; i++) {
            String str = strings[i];

            heap.add(new AbstractMap.SimpleEntry<>(i, str));
        }

        StringBuilder sb = new StringBuilder();

        while (!heap.isEmpty()) {
            sb.append(heap.poll().getValue()).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        for (int i = 0; i < sb.length(); i++) {
            if (Character.isUpperCase(sb.charAt(i))) {
                sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
                break;
            }
        }

        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));

        return sb.toString();
    }
}
