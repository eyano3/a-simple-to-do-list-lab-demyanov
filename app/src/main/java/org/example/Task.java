package org.example;

public class Task {
  private String description;
  private boolean complete;

  public Task(String description) {
    this.description = description;
    this.complete = false;
  }

  public String getDescription() {
    return description;
  }

  public boolean isComplete() {
    return complete;
  }

  public void markComplete() {
    complete = true;
  }
}
