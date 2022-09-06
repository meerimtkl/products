package kg.megacom.products.services;

import kg.megacom.products.models.dto.PriceDto;
import kg.megacom.products.models.dto.requests.ProductRequest;
import kg.megacom.products.models.entities.Product;

public interface PriceService {

    PriceDto save(ProductRequest productRequest, Product product);
}
