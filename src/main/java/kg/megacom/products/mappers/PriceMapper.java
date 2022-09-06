package kg.megacom.products.mappers;

import kg.megacom.products.mappers.base.CrudMapper;
import kg.megacom.products.models.dto.PriceDto;
import kg.megacom.products.models.dto.requests.ProductRequest;
import kg.megacom.products.models.entities.Price;
import kg.megacom.products.models.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface PriceMapper extends CrudMapper<Price, PriceDto> {

    PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);
    @Mapping(source="price",target="price")
    @Mapping(source = "productId", target ="product.id" )
    Price productRequestToPrice(ProductRequest productRequest);

    PriceDto toDto(Price price);
 Price findByPrice(Double price);


}

