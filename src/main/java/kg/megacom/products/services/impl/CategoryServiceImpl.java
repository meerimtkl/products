package kg.megacom.products.services.impl;

import kg.megacom.products.dao.CategoryRepo;
import kg.megacom.products.mappers.CategoryMapper;
import kg.megacom.products.models.dto.CategoryDto;
import kg.megacom.products.models.dto.requests.ProductRequest;
import kg.megacom.products.models.entities.Category;
import kg.megacom.products.models.entities.Price;
import kg.megacom.products.models.entities.Product;
import kg.megacom.products.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
        this.categoryMapper = CategoryMapper.INSTANCE;
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        Category category = categoryMapper.toEntity(categoryDto);
        category = categoryRepo.save(category);
        return categoryMapper.toDto(category);

    }

    @Override
    public boolean existsById(Long id) {
        return categoryRepo.existsById(id);
    }

    @Override
    public void checkExistsByIdAndActive(Long id) {
        Category category = findById(id);
        if (!category.isActive())
            throw new RuntimeException("Категория не активна!");
    }

    @Override
    public Category findById(Long id) {
        return categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Категория не найдена!"));
    }


}
