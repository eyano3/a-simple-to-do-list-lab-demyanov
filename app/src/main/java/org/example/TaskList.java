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
        printTasks(tasks);
        return tasks;
    }

    public List<Task> complete() {
        List<Task> completeTasks = new ArrayList<>();

        for (Task task : tasks) {
            if (task.isComplete()) {
                completeTasks.add(task);
            }
        }

        printTasks(completeTasks);
        return completeTasks;
    }

    public List<Task> incomplete() {
        List<Task> incompleteTasks = new ArrayList<>();

        for (Task task : tasks) {
            if (!task.isComplete()) {
                incompleteTasks.add(task);
            }
        }

        printTasks(incompleteTasks);
        return incompleteTasks;
    }

    public void clear() {
        tasks.clear();
    }

    private void printTasks(List<Task> tasksToPrint) {
        if (tasksToPrint.isEmpty()) {
            System.out.println("There are no applicable tasks.");
        }

        for (int i = 0; i < tasksToPrint.size(); i++) {
            System.out.println((i + 1) + ". " + tasksToPrint.get(i).getDescription());
        }
    }
}

