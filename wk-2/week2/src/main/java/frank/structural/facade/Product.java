package frank.structural.facade;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {
    private String id;
    private String name;
    private String type; // e.g., "Car" or "Motorbike"


    @Override
    public String toString() {
        return type + ": " + name + " (ID: " + id + ")";
    }
}