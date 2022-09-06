package kg.megacom.products.dao;

import kg.megacom.products.models.entities.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepo extends JpaRepository<Discount,Long> {
    Discount findByProductId(Long id);
}
