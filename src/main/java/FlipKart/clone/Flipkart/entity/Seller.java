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
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "seller")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name")
    @NotBlank(message = "name is mandatory")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "name should be in correct formate:")
    String name;

    @Column(name = "businessName")
    @NotBlank(message = "Business name is mandatory:")
    String businessName;

    @Column(name = "sellerId", unique = true)
    String sellerId;

    @Column(name = "GSTNumber", unique = true)
    String GSTNumber;

    @Column(name = "number", unique = true)
    @NotBlank(message = "mobile number is mandatory")
    String number;

    @Column(name = "email", unique = true)
    @NotBlank(message = "email is mandatory")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$",
            message = "Invalid email format, Please provide valid email formate: ")
    String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    UserType type;

    @NotBlank(message = "Business type is mandatory: ")
    @Column(name = "businessType")
    String businessType;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;

    @Column(name = "panNumber", unique = true)
    String panNumber;

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

    @NotBlank(message = "Vendor address is mandatory: ")
    @Column(name = "address", length = 300)
    private String vendorAddress;

}
