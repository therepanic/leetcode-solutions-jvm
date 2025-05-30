package designTaskManager;

import java.util.*;

public class TaskManager {

    private final Map<Integer, List<Integer>> tasks;
    private final PriorityQueue<List<Integer>> tasksByPrior;

    public TaskManager(List<List<Integer>> tasks) {
        this.tasks = new HashMap<>();
        this.tasksByPrior = new PriorityQueue<>((p1, p2) -> {
            if (p2.get(2).equals(p1.get(2))) {
                return Integer.compare(p2.get(1), p1.get(1));
            } else {
                return Integer.compare(p2.get(2), p1.get(2));
            }
        });
        for (List<Integer> task : tasks) {
            this.tasksByPrior.add(task);
            this.tasks.put(task.get(1), List.of(task.get(0), task.get(2)));
        }

    }

    public void add(int userId, int taskId, int priority) {
        this.tasksByPrior.add(List.of(userId, taskId, priority));
        this.tasks.put(taskId, List.of(userId, priority));
    }

    public void edit(int taskId, int newPriority) {
        if (!this.tasks.containsKey(taskId)) {
            return;
        }
        List<Integer> entry = this.tasks.get(taskId);
        this.tasks.put(taskId, List.of(entry.get(0), newPriority));
        tasksByPrior.add(List.of(entry.get(0), taskId, newPriority));
    }

    public void rmv(int taskId) {
        if (!this.tasks.containsKey(taskId)) {
            return;
        }
        this.tasks.remove(taskId);
    }

    public int execTop() {
        while (!this.tasksByPrior.isEmpty()) {
            List<Integer> prior = this.tasksByPrior.poll();
            List<Integer> executed = this.tasks.get(prior.get(1));
            if (executed != null && executed.get(0).equals(prior.get(0)) && executed.get(1).equals(prior.get(2))) {
                this.tasks.remove(prior.get(1));
                return prior.get(0);
            }
        }
        return -1;
    }

}

