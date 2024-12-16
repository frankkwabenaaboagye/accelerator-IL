package frank.advanceDS.taskscheduling;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    private List<Task> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    public void addTask(Task task) {
        heap.add(task);
        heapifyUp(heap.size() - 1);
    }

    public Task popTask() {
        if (heap.isEmpty()) {
            return null; // No tasks to pop
        }
        Task root = heap.getFirst();
        Task last = heap.removeLast();
        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }
        return root;
    }

    public Task peekTask() {
        return heap.isEmpty() ? null : heap.getFirst();
    }

    // Heapify up
    private void heapifyUp(int index) {
        while (index > 0 && heap.get(index).priority < heap.get(parent(index)).priority) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    // Heapify down
    private void heapifyDown(int index) {
        int left = leftChild(index);
        int right = rightChild(index);
        int smallest = index;

        if (left < heap.size() && heap.get(left).priority < heap.get(smallest).priority) {
            smallest = left;
        }
        if (right < heap.size() && heap.get(right).priority < heap.get(smallest).priority) {
            smallest = right;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        Task temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    public int size() {
        return heap.size();
    }
}

