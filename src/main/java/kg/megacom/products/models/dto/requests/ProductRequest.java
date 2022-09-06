package kg.megacom.products.models.dto.requests;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.annotation.sql.DataSourceDefinition;

@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
public class ProductRequest {
    Long productId;
    String name;
    double price;
    int percent;
    Long categoryId;

 int discountDuration;
//    private Long categoryId;
//    private String title;
//    private double price;
//    private int percent;
//    private int discountDuration;

}
