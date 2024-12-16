package frank.advanceDS.taskscheduling;

public class TaskScheduler {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.addTask(new Task(1, 3, "Task 1: Low priority"));
        minHeap.addTask(new Task(2, 1, "Task 2: High priority"));
        minHeap.addTask(new Task(3, 2, "Task 3: Medium priority"));

        System.out.println("Scheduled Tasks in Priority Order:");

        while (minHeap.size() > 0) {
            Task task = minHeap.popTask();
            System.out.println(task);
        }
    }
}