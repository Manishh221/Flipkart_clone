package FlipKart.clone.Flipkart.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonPropertyOrder({"id", "name", "catagoryType", "SKU", "brand", "price", "discription"})
@Table(name = "product")
public class Product {

    @Column(name = "mainCatagoryType")
    @NotBlank(message = "Main catagory type should not be null:")
    String mainCatagoryType;

    @Column(name = "subCategoryType")
    @NotBlank(message = "Main category type should not be null:")
    String subCategoryType;

    @Column(name = "SKU", unique = true)
    String SKU;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotBlank(message = "product name should not be null:")
    private String name;

    @Column(name = "discription")
    @NotBlank(message = "Discription is mandatory: ")
    private String discription;

    @Column(name = "brand")
    @NotBlank(message = "brand name should not be null:")
    private String brand;

    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @Digits(integer = 10, fraction = 2, message = "Price must be a valid amount with max 2 decimal places")
    @NotNull(message = "Price is mandatory")
    private BigDecimal price;
}
