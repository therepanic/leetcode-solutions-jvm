package designBrowserHistory;

public class BrowserHistory {
    private static class LinkedList<T> {
        T value;
        LinkedList<T> next;
        LinkedList<T> prev;

        public LinkedList(T value) {
            this.value = value;
        }
    }
    private LinkedList<String> history;

    public BrowserHistory(String homepage) {
        this.history = new LinkedList<>(homepage);
    }

    public void visit(String url) {
        history.next = new LinkedList<>(url);
        history.next.prev = history;

        history = history.next;
    }

    public String back(int steps) {
        String result = history.value;

        for (int i = 0; i < steps; i++) {
            if (history.prev == null) {
                break;
            }
            history = history.prev;
            result = history.value;
        }

        return result;
    }

    public String forward(int steps) {
        String result = history.value;

        for (int i = 0; i < steps; i++) {
            if (history.next == null) {
                break;
            }
            history = history.next;
            result = history.value;
        }

        return result;
    }
}
