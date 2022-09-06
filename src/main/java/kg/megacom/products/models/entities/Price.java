package kg.megacom.products.models.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@Table(name="prices")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    double price;

    Date startDate;
    Date endDate;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;
}
