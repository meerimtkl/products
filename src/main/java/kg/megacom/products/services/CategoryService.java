package kg.megacom.products.services;

import kg.megacom.products.models.dto.CategoryDto;
import kg.megacom.products.models.dto.requests.ProductRequest;
import kg.megacom.products.models.entities.Category;
import kg.megacom.products.models.entities.Product;
import org.springframework.stereotype.Service;


public interface CategoryService {
     CategoryDto save(CategoryDto categoryDto);
     boolean existsById(Long id);
     void checkExistsByIdAndActive(Long id);
     Category findById(Long id);


  //  CategoryDto save(ProductRequest productRequest, Product product);
}
