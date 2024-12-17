package frank.behavioral.strategy.context;

import frank.behavioral.strategy.strategyinterface.SortStrategy;
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