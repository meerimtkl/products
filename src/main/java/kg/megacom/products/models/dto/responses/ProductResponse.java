package kg.megacom.products.models.dto.responses;

import kg.megacom.products.models.dto.CategoryDto;
import kg.megacom.products.models.dto.DiscountDto;
import kg.megacom.products.models.dto.PriceDto;
import kg.megacom.products.models.dto.ProductDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
public class ProductResponse {
    ProductDto product;
    CategoryDto category;
    PriceDto price;
    DiscountDto discount;
//    private Long productId;
//    private Long categoryId;
//    private String title;
//    private double price;
//    private int percent;
//    private String discountEndDate;
}
