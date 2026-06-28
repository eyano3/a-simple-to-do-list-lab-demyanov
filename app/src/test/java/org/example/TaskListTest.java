package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


class TaskListTest {
    @Test
    void newTaskStoresDescriptionAndStartsIncomplete() {
        Task task = new Task("Submit lab");

        assertEquals("Submit lab", task.getDescription());
        assertFalse(task.isComplete());
    }

    @Test
    void markCompleteMakesTaskComplete() {
        Task task = new Task("Read chapter");

        task.markComplete();

        assertTrue(task.isComplete());
    }

    @Test
    void newTaskListHasNoTasks() {
        TaskList taskList = new TaskList();

        assertTrue(taskList.all().isEmpty());
    }

    @Test
    void allReturnsOneAddedTask() {
        TaskList taskList = new TaskList();
        Task task = new Task("Buy groceries");

        taskList.add(task);

        assertEquals(Arrays.asList(task), taskList.all());
    }

    @Test
    void allReturnsManyAddedTasksInOrder() {
        TaskList taskList = new TaskList();
        Task first = new Task("Write outline");
        Task second = new Task("Draft essay");
        Task third = new Task("Submit essay");

        taskList.add(first);
        taskList.add(second);
        taskList.add(third);

        assertEquals(Arrays.asList(first, second, third), taskList.all());
    }

    @Test
    void completeReturnsOnlyCompletedTasks() {
        TaskList taskList = new TaskList();
        Task completeTask = new Task("Finish worksheet");
        Task incompleteTask = new Task("Start project");

        completeTask.markComplete();
        taskList.add(completeTask);
        taskList.add(incompleteTask);

        assertEquals(Arrays.asList(completeTask), taskList.complete());
    }

    @Test
    void incompleteReturnsOnlyIncompleteTasks() {
        TaskList taskList = new TaskList();
        Task completeTask = new Task("Wash dishes");
        Task incompleteTask = new Task("Fold laundry");

        completeTask.markComplete();
        taskList.add(completeTask);
        taskList.add(incompleteTask);

        assertEquals(Arrays.asList(incompleteTask), taskList.incomplete());
    }

    @Test
    void completeReturnsEmptyWhenNoTasksAreComplete() {
        TaskList taskList = new TaskList();

        taskList.add(new Task("Plan trip"));
        taskList.add(new Task("Pack snacks"));

        assertTrue(taskList.complete().isEmpty());
    }

    @Test
    void incompleteReturnsEmptyWhenEveryTaskIsComplete() {
        TaskList taskList = new TaskList();
        Task first = new Task("Check mail");
        Task second = new Task("Water plant");

        first.markComplete();
        second.markComplete();

        taskList.add(first);
        taskList.add(second);

        assertTrue(taskList.incomplete().isEmpty());
    }

    @Test
    void filtersReflectTasksMarkedCompleteAfterBeingAdded() {
        TaskList taskList = new TaskList();
        Task task = new Task("Practice piano");

        taskList.add(task);

        assertEquals(Arrays.asList(task), taskList.incomplete());

        task.markComplete();

        assertEquals(Arrays.asList(task), taskList.complete());
        assertTrue(taskList.incomplete().isEmpty());
    }

    @Test
    void clearRemovesEveryTask() {
        TaskList taskList = new TaskList();

        taskList.add(new Task("Task one"));
        taskList.add(new Task("Task two"));

        taskList.clear();

        assertTrue(taskList.all().isEmpty());
        assertTrue(taskList.complete().isEmpty());
        assertTrue(taskList.incomplete().isEmpty());
    }

}

