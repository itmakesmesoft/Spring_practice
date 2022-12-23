package studio.thinkground.testproject.data.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;
import studio.thinkground.testproject.data.dto.ProductDto;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="product") // db에 테이블을 자동으로 생성해주는 어노테이션
public class ProductEntity {
    @Id
    String productId;
    String productName;
    Integer productPrice;
    Integer productStock;
    
    
    public ProductDto toDto() {
        return ProductDto.builder()
                .productId(productId)
                .productName(productName)
                .productPrice(productPrice)
                .productStock(productStock)
                .build();
    }
}
