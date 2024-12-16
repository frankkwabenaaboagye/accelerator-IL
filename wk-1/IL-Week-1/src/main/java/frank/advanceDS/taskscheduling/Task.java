package frank.advanceDS.taskscheduling;

public class Task {
    int taskId;
    int priority;  // Lower number means higher priority
    String description;

    public Task(int taskId, int priority, String description) {
        this.taskId = taskId;
        this.priority = priority;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{id=" + taskId + ", priority=" + priority + ", description='" + description + "'}";
    }
}

