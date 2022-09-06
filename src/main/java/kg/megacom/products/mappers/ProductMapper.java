package kg.megacom.products.mappers;

import kg.megacom.products.mappers.base.CrudMapper;
import kg.megacom.products.models.dto.ProductDto;
import kg.megacom.products.models.dto.requests.ProductRequest;
import kg.megacom.products.models.entities.Category;
import kg.megacom.products.models.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Mapper
public interface ProductMapper extends CrudMapper<Product, ProductDto> {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "name", target = "title")
    Product productRequestToProduct(ProductRequest productRequest);

    ProductDto toProductFromPR(ProductRequest productRequest);


}
