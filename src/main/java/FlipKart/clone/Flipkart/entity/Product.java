package FlipKart.clone.Flipkart.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name")
    @NotNull(message = "product name should not be null:")
    String name;

    @Column(name = "catagoryType")
    @NotNull(message = "catagory type should not be null:")
    String catagoryType;

    @Column(name = "SKU", unique = true)
    String SKU;

    @Column(name = "brand")
    @NotNull(message = "brand name should not be null:")
    String brand;

    @Column(name = "price")
    @NotNull(message = "price should not be null:")
    float price;


}
