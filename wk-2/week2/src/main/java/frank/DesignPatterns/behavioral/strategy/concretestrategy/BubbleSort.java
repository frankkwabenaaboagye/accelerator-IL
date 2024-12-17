package frank.DesignPatterns.behavioral.strategy.concretestrategy;

import frank.DesignPatterns.behavioral.strategy.strategyinterface.SortStrategy;

import java.util.Arrays;

public class BubbleSort implements SortStrategy {
    @Override
    public void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println("Bubble Sort: " + Arrays.toString(array));
    }
}
