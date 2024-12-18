package frank.ims.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ims_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;
    private int quantity;
    private String status; // PENDING, COMPLETED
}