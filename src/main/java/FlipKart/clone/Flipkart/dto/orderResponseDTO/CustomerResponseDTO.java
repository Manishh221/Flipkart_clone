package FlipKart.clone.Flipkart.dto.orderResponseDTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerResponseDTO {

    private String customerName;
    private String moblileNumber;
    private String address;
    private String email;
}
