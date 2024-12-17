package frank.DesignPatterns.behavioral.strategy;

import frank.DesignPatterns.behavioral.strategy.context.SortingContext;
import frank.DesignPatterns.behavioral.strategy.concretestrategy.BubbleSort;
import frank.DesignPatterns.behavioral.strategy.concretestrategy.QuickSort;

public class ClientCode {
    public static void main(String[] args) {
        int[] array = {5, 3, 8, 1, 2};

        SortingContext context = new SortingContext(new BubbleSort());
        context.sortArray(array);

        int[] newArray = {5, 3, 8, 1, 2};
        context.setStrategy(new QuickSort());
        context.sortArray(newArray);
    }
}