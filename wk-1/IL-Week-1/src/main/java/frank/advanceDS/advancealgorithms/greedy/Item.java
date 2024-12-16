package frank.advanceDS.advancealgorithms.greedy;

public class Item {
    int value, weight;

    // Constructor to initialize an item
    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    // Method to calculate the value-to-weight ratio
    public double getValuePerWeight() {
        return (double) value / weight;
    }
}
