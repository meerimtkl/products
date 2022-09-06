package kg.megacom.products.mappers;

import kg.megacom.products.mappers.base.CrudMapper;
import kg.megacom.products.models.dto.CategoryDto;
import kg.megacom.products.models.dto.DiscountDto;
import kg.megacom.products.models.dto.requests.ProductRequest;
import kg.megacom.products.models.entities.Category;
import kg.megacom.products.models.entities.Discount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface DiscountMapper extends CrudMapper<Discount, DiscountDto> {
    DiscountMapper INSTANCE = Mappers.getMapper(DiscountMapper.class);

    Discount productRequestToDiscount(ProductRequest productRequest);
}
