package kg.megacom.products.services.impl;

import kg.megacom.products.dao.DiscountRepo;
import kg.megacom.products.mappers.DiscountMapper;
import kg.megacom.products.models.dto.DiscountDto;
import kg.megacom.products.models.dto.requests.ProductRequest;
import kg.megacom.products.models.entities.Discount;
import kg.megacom.products.models.entities.Product;
import kg.megacom.products.services.DiscountService;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
@Service
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepo discountRepo;
    private final DiscountMapper discountMapper;
    public DiscountServiceImpl(DiscountRepo discountRepo) {
        this.discountRepo = discountRepo;
        this.discountMapper = DiscountMapper.INSTANCE;
    }

    @Override
    public DiscountDto save(ProductRequest productRequest, Product product) {

        Discount discount = discountMapper.productRequestToDiscount(productRequest);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, productRequest.getDiscountDuration());

        discount.setStartDate(new Date());
      //  discount.setEndDate(cal.getTime());
        discount.setEndDate(new Date(9999,12,31));
        discount.setProduct(product);

        discountRepo.save(discount);

        return discountMapper.toDto(discount);
    }
}
