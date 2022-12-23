package studio.thinkground.testproject.data.repository;

import studio.thinkground.testproject.data.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {
}
