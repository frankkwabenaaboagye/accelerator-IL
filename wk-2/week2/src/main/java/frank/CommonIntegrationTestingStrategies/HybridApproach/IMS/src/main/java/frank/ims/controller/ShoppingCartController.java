package frank.ims.controller;

import frank.ims.model.CartItem;
import frank.ims.service.real.ShoppingCartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {
    private final ShoppingCartService cartService;

    public ShoppingCartController(ShoppingCartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public List<CartItem> getCart() {
        return cartService.getCart();
    }

    @PostMapping
    public void addToCart(@RequestBody CartItem item) {
        cartService.addToCart(item);
    }
}