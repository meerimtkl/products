package kg.megacom.products.services.impl;

import kg.megacom.products.dao.PriceRepo;
import kg.megacom.products.dao.ProductRepo;
import kg.megacom.products.mappers.PriceMapper;
import kg.megacom.products.mappers.ProductMapper;
import kg.megacom.products.models.dto.CategoryDto;
import kg.megacom.products.models.dto.DiscountDto;
import kg.megacom.products.models.dto.PriceDto;
import kg.megacom.products.models.dto.requests.ProductRequest;
import kg.megacom.products.models.dto.responses.ProductResponse;
import kg.megacom.products.models.entities.Price;
import kg.megacom.products.models.entities.Product;
import kg.megacom.products.services.CategoryService;
import kg.megacom.products.services.DiscountService;
import kg.megacom.products.services.PriceService;
import kg.megacom.products.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final PriceRepo priceRepo;
    private final ProductMapper productMapper;
    private final CategoryService categoryService;
    private final PriceService priceService;
    private final DiscountService discountService;
    private final PriceMapper priceMapper;

    public ProductServiceImpl(ProductRepo productRepo, CategoryService categoryService, PriceService priceService, DiscountService discountService, PriceRepo priceRepo) {
        this.productRepo = productRepo;
        this.categoryService = categoryService;
        this.priceService = priceService;
        this.discountService = discountService;
        this.priceRepo = priceRepo;
        this.priceMapper = PriceMapper.INSTANCE;
        this.productMapper = ProductMapper.INSTANCE;
    }
    //если товар есть при обновлении
    //проверять стоимость, скидку если они отличаются титл помеял актуальная цена отличсается от предыдущей
    // я должжна обновить enddate=new date? enddate=max.value
    //   проверять скидку
    //         endDate=maxValue; update товара добавить новую запись

    @Override
    public ProductResponse save(ProductRequest productRequest) {

        Product product = productMapper.productRequestToProduct(productRequest);

        categoryService.checkExistsByIdAndActive(product.getCategory().getId());

        product = productRepo.save(product);

        PriceDto priceDto = priceService.save(productRequest, product);
        DiscountDto discountDto = discountService.save(productRequest, product);



        ProductResponse productResponse = new ProductResponse();
        productResponse.setProduct(productMapper.toDto(product));
        return productResponse;

    }
    @Override
    public ProductResponse update(ProductRequest productRequest) {


        ProductResponse productResponse = new ProductResponse();
        Product product = productMapper.productRequestToProduct(productRequest);
        Product dbProduct = productRepo.findByTitle(product.getTitle());
        System.out.println("dbproduct"+dbProduct);
        if (dbProduct == null) {


            categoryService.checkExistsByIdAndActive(product.getCategory().getId());

            product = productRepo.save(product);

            PriceDto priceDto = priceService.save(productRequest, product);
            DiscountDto discountDto = discountService.save(productRequest, product);
        //    CategoryDto categoryDto=categoryService.save(productRequest,product);

            productResponse.setProduct(productMapper.toDto(product));


        } else {
            Price price = priceMapper.productRequestToPrice(productRequest);


            Price dbPrice = priceRepo.findPriceByProductIdOrderByEndDateDesc(dbProduct.getId());
            System.out.println("dbPrice"+dbPrice);
            if (dbPrice == null) {
                price.setStartDate(new Date());
                price.setEndDate(new Date(Long.MAX_VALUE));

                price.setPrice(price.getPrice());
                price = priceRepo.save(price);

            } else if (dbPrice.getPrice() != price.getPrice()) {

                dbPrice.setEndDate(new Date());
                dbPrice = priceRepo.save(dbPrice);
Price priceNew=new Price();
priceNew.setId(dbPrice.getId()+1);
                priceNew.setStartDate(new Date());
                priceNew.setEndDate(new Date(9999,12,31));
                priceNew.setProduct(product);
                priceNew = priceRepo.save(priceNew);

                productResponse.setPrice(priceMapper.toDto(priceNew));
            }

            //если товар есть при обновлении
            //проверять стоимость, скидку если они отличаются title помеял актуальная цена отличсается от предыдущей
            // я должжна обновить enddate=new date? enddate=max.value
            //   проверять скидку
            //         endDate=maxValue; update товара добавить новую запись
           /*
            -- FOLLOWINGS  AUTHOR MEERIM
           if (priceRepo.findByPrice(price.getPrice()).equals(price)) {
                price.setPrice(price.getPrice());

                PriceDto priceDto = priceService.save(productRequest, product);
                DiscountDto discountDto = discountService.save(productRequest, product);
             //   ProductResponse productResponse = new ProductResponse();
                productResponse.setProduct(productMapper.toDto(product));


            }*/
        }
        return productResponse;

    }
}
