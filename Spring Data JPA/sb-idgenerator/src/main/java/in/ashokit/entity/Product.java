package in.ashokit.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_tbl")
@NoArgsConstructor
@Data
public class Product {
    @Id
    @TableGenerator(
            name = "table_gen",
            table = "id_table",
            pkColumnName = "gen_name",
            valueColumnName = "gen_value",
            pkColumnValue = "product_id",
            initialValue = 1001,
            allocationSize = 2
    )
    @GeneratedValue(
            strategy = GenerationType.TABLE,
            generator = "table_gen"
    )
    private Integer product_id;
    private String product_name;
    private double price;
}
