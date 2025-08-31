package FlipKart.clone.Flipkart.entity;

import FlipKart.clone.Flipkart.converter.JsonConverter;
import FlipKart.clone.Flipkart.dto.orderResponseDTO.CustomerResponseDTO;
import FlipKart.clone.Flipkart.dto.orderResponseDTO.ProductResponseDTO;
import FlipKart.clone.Flipkart.dto.orderResponseDTO.SellerResponseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
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

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private CustomerResponseDTO customerDetails;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private SellerResponseDTO sellerDetails;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private ProductResponseDTO productDetails;

    @Column(name = "quantity")
    private int qty;

    @Column(name = "orderId", unique = true)
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
