//package in.ashokit.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Entity
//@NoArgsConstructor
//@Data
//@Table(name = "order_tbl")
//public class Order {
//    @Id
//    @SequenceGenerator(
//            name = "order_generator",
//            sequenceName = "order_sequence",
//            initialValue = 1001,
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "order_generator"
//    )
//    private Integer orderId;
//    private String orderName;
//}
