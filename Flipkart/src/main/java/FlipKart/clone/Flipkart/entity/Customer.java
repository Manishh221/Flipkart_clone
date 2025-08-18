package FlipKart.clone.Flipkart.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "customer")
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int count;

    @NotNull(message = "Name is Mandatory")
    @Column(name = "name")
    String name;

    @NotNull(message = "Mobile number is mandatory")
    @Column(name = "mobileNumber")
    String mobileNumber;

    @Column(name = "email", unique = true)
    @NotNull(message = "Email is mandatory")
    String email;

    @Column(name = "customerId", unique = true)
    String customerId;

    @Column(name = "customerCartId", unique = true)
    String customerCartId;

    @Column(name = "type")
    String type;
}
