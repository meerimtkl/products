package kg.megacom.products.dao;

import kg.megacom.products.models.entities.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepo extends JpaRepository<Price,Long> {
    Price findPriceByProductIdOrderByEndDateDesc(Long productID);

}
