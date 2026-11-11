package in.ashokit.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_tbl")
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer user_id;
    private String user_name;
    private String user_pass;
    private Long user_phno;
    private String user_address;
}
