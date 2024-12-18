package frank.ims.model;

import lombok.Data;

@Data
public class CartItem {
    private Long productId;
    private int quantity;
}