package org.example;
import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public List<Task> all() {
        return tasks;
    }

    public List<Task> complete() {
        List<Task> completeTasks = new ArrayList<>();

        for (Task task : tasks) {
            if (task.isComplete()) {
                completeTasks.add(task);
            }
        }

        return completeTasks;
    }

    public List<Task> incomplete() {
        List<Task> incompleteTasks = new ArrayList<>();

        for (Task task : tasks) {
            if (!task.isComplete()) {
                incompleteTasks.add(task);
            }
        }

        return incompleteTasks;
    }

    public void clear() {
        tasks.clear();
    }
}
