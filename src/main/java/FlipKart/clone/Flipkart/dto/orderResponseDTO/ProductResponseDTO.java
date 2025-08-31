package FlipKart.clone.Flipkart.dto.orderResponseDTO;

import FlipKart.clone.Flipkart.enums.MainCategory;
import FlipKart.clone.Flipkart.enums.SubCategory;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponseDTO {

    private String productName;
    private MainCategory mainCategory;
    private SubCategory subCategory;
    private String brand;
}
