package kg.megacom.products.mappers;

import kg.megacom.products.mappers.base.CrudMapper;
import kg.megacom.products.models.dto.CategoryDto;
import kg.megacom.products.models.entities.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface CategoryMapper extends CrudMapper<Category,CategoryDto> {
CategoryMapper INSTANCE= Mappers.getMapper(CategoryMapper.class);

    @Mapping (source = "name", target = "title")
    Category toEntity(CategoryDto categoryDto);
    @InheritInverseConfiguration

    CategoryDto toDto(Category category);






}
