package in.ashokit.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "shipping_address")
@Getter
@Setter
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer address_Id;

    private String houseName;

    private String state;

    private String zipCode;

    private String addressType;

    private String country;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
}
