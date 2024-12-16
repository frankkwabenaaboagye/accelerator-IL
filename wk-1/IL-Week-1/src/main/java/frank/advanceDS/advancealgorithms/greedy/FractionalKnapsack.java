package frank.advanceDS.advancealgorithms.greedy;

import java.util.Arrays;

public class FractionalKnapsack {


    public static double getMaxValue(Item[] items, int capacity) {
        // Sort the items based on value-to-weight ratio in descending order
        Arrays.sort(items, (i1, i2) -> Double.compare(i2.getValuePerWeight(), i1.getValuePerWeight()));

        double totalValue = 0.0;
        int currentWeight = 0;

        for (Item item : items) {
            // If the item can be fully added to the knapsack
            if (currentWeight + item.weight <= capacity) {
                currentWeight += item.weight;
                totalValue += item.value;
            } else {
                // If we can't take the full item, take the fractional part
                int remainingWeight = capacity - currentWeight;
                totalValue += item.value * ((double) remainingWeight / item.weight);
                break; // Knapsack is full
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        // Example items: value, weight
        Item[] items = {
                new Item(60, 10),
                new Item(100, 20),
                new Item(120, 30)
        };

        int capacity = 50; // Knapsack capacity

        // Get the maximum value we can carry
        double maxValue = getMaxValue(items, capacity);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}