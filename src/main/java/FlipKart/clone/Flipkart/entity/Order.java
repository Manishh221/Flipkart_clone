package FlipKart.clone.Flipkart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

}
