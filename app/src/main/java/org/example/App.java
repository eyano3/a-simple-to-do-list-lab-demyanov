package org.example;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TaskList list = new TaskList();

        System.out.println("Welcome to the Task List!");

        int choice = -1;

        while (choice != 0) {
            System.out.println();
            System.out.println("Please select from the following options:");
            System.out.println("1. Add task");
            System.out.println("2. Complete task");
            System.out.println("3. View all tasks");
            System.out.println("4. View complete tasks");
            System.out.println("5. View incomplete tasks");
            System.out.println("6. Clear list");
            System.out.println("0. Quit");

            choice = checkValidInput(input, "Choose an option: ");

            if (choice == 1) {
                System.out.print("Enter task description: ");
                String description = input.nextLine();
                list.add(new Task(description));
                System.out.println("Your task has been added.");

            } else if (choice == 2) {
                List<Task> incompleteTasks = list.incomplete();

                if (!incompleteTasks.isEmpty()) {
                    int taskNumber = checkValidInput(input, "Enter task number to complete: ");

                    if (taskNumber >= 1 && taskNumber <= incompleteTasks.size()) {
                        incompleteTasks.get(taskNumber - 1).markComplete();
                        System.out.println("Task has been marked as complete.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                }

            } else if (choice == 3) {
                list.all();

            } else if (choice == 4) {
                list.complete();

            } else if (choice == 5) {
                list.incomplete();

            } else if (choice == 6) {
                list.clear();
                System.out.println("Your task list has been cleared.");
            } else if (choice != 0) {
                System.out.println("Invalid menu option.");
            }
        }
        System.out.println("Thank you for using the Task List.");
        input.close();
    }

    private static int checkValidInput(Scanner input, String message) {
        System.out.print(message);

        while (!input.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            input.nextLine();
            System.out.print(message);
        }

        int number = input.nextInt();
        input.nextLine();

        return number;
    }
}