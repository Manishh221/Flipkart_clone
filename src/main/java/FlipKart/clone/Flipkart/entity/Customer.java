package FlipKart.clone.Flipkart.entity;

import FlipKart.clone.Flipkart.enums.UserType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int count;

    @NotBlank(message = "Name is Mandatory")
    @Column(name = "name")
    String name;

    @NotBlank(message = "Mobile number is mandatory")
    @Column(name = "mobileNumber")
    String mobileNumber;

    @Column(name = "email", unique = true)
    @NotBlank(message = "Email is mandatory")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "Invalid email format")
    String email;

    @Column(name = "customerId", unique = true)
    String customerId;

    @Column(name = "customerCartId", unique = true)
    String customerCartId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    UserType userType;

    @CreationTimestamp
    @JsonFormat(pattern = "d MMMM yyyy")
    @Column(name = "CreatedDate")
    private LocalDate createdDate;

    @CreationTimestamp
    @JsonFormat(pattern = "HH:mm:ss")
    @Column(name = "createdTime")
    private LocalTime createdTime;

    @UpdateTimestamp
    @JsonFormat(pattern = "d MMMM yyyy")
    @Column(name = "updatedDate")
    private LocalDate updatedDate;

    @UpdateTimestamp
    @JsonFormat(pattern = "HH:mm:ss")
    @Column(name = "updatedTime")
    private LocalTime updatedTime;

    @NotBlank(message = "customer address is mandatory: ")
    @Column(name = "address", length = 300)
    private String dropAddress;

}
