package FlipKart.clone.Flipkart.entity;

import FlipKart.clone.Flipkart.enums.MainCategory;
import FlipKart.clone.Flipkart.enums.SubCategory;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "mainCatagoryType")
    MainCategory mainCatagoryType;

    @Enumerated(EnumType.STRING)
    @Column(name = "subCategoryType")
    @NotNull(message = "sub category type should not be null:")
    SubCategory subCategoryType;

    @Column(name = "SKU", unique = true)
    String SKU;

    @Column(name = "name")
    @NotBlank(message = "product name should not be null:")
    private String name;

    @Column(name = "discription", length = 1000)
    @NotBlank(message = "Discription is mandatory: ")
    private String discription;

    @Column(name = "brand")
    @NotBlank(message = "brand name should not be null:")
    private String brand;

    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @Digits(integer = 10, fraction = 2, message = "Price must be a valid amount with max 2 decimal places")
    @NotNull(message = "Price is mandatory")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

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

}
