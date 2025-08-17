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
@Table(name = "seller")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int count;

    @Column(name = "name")
    @NotNull(message = "name is mandatory")
    String name;

    @Column(name = "sellerShopName")
    @NotNull(message = "seller shop name is mandatory:")
    String sellerShopName;

    @Column(name = "sellerId", unique = true)
    String sellerId;

    @Column(name = "GSTNumber", unique = true)
    String GSTNumber;

    @Column(name = "number", unique = true)
    @NotNull(message = "mobile number is mandatory")
    String number;

    @Column(name = "email", unique = true)
    @NotNull(message = "email is mandatory")
    String email;

    @Column(name = "type")
    String type;

    @Column(name = "panNumber", unique = true)
    String panNumber;

}
