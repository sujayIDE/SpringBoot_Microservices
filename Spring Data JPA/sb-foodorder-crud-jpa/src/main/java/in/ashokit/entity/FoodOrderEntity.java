package in.ashokit.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Food-Order-tbl")
@Data
public class FoodOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    private String customerName;

    private String foodName;

    private Integer price;

    @Enumerated(value = EnumType.STRING)
    private Status orderStatus;
}
