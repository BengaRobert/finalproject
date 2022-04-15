package ro.sda.java30.finalproject.Mappers;

import org.springframework.stereotype.Service;
import ro.sda.java30.finalproject.entities.Product;
import ro.sda.java30.finalproject.model.ProductDto;

@Service
public class ProductMapper implements Mapper<Product, ProductDto> {

    @Override
    public Product mapDtoToEntity(ProductDto dto) {
        Product entity = new Product();
        entity.setId(dto.getId());
        entity.setProduct(dto.getProduct());
        entity.setQuantity(dto.getQuantity());
        entity.setPrice(dto.getPrice());
        return entity;
    }

    @Override
    public ProductDto mapEntityToDto(Product entity) {
        ProductDto dto = new ProductDto();
        dto.setId(entity.getId());
        dto.setProduct(entity.getProduct());
        dto.setQuantity(entity.getQuantity());
        dto.setPrice(entity.getPrice());
        return dto;
    }
}
