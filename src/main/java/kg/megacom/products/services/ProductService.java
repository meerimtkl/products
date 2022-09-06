package kg.megacom.products.services;

import kg.megacom.products.models.dto.requests.ProductRequest;
import kg.megacom.products.models.dto.responses.ProductResponse;
import org.springframework.stereotype.Service;

public interface ProductService {
    ProductResponse save(ProductRequest productRequest);
    ProductResponse update(ProductRequest productRequest);

}
