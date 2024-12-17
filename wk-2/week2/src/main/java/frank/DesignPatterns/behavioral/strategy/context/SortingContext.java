package frank.DesignPatterns.behavioral.strategy.context;

import frank.DesignPatterns.behavioral.strategy.strategyinterface.SortStrategy;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class SortingContext {
    private SortStrategy strategy;

    public void sortArray(int[] array) {
        strategy.sort(array);
    }
}