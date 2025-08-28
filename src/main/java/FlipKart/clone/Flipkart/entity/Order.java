package FlipKart.clone.Flipkart.entity;

import FlipKart.clone.Flipkart.converter.JsonConverter;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "customerOrder")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Convert(converter = JsonConverter.class)
    @Column(columnDefinition = "json", name = "customerDetails")
    private Customer customerDetails;

    @Convert(converter = JsonConverter.class)
    @Column(columnDefinition = "json", name = "sellerDetails")
    private Seller sellerDetails;

    @Convert(converter = JsonConverter.class)
    @Column(columnDefinition = "json", name = "productDetails")
    private Product productDetails;

    @Column(name = "quantity")
    private int qty;

    @Column(name = "orderId", length = 10, unique = true)
    private String orderId;

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
