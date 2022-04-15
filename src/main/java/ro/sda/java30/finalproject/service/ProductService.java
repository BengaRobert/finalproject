package ro.sda.java30.finalproject.service;

import org.springframework.stereotype.Service;
import ro.sda.java30.finalproject.Mappers.ProductMapper;
import ro.sda.java30.finalproject.entities.Product;
import ro.sda.java30.finalproject.model.ProductDto;
import ro.sda.java30.finalproject.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductDto save(ProductDto form) {
        Product product= productMapper.mapDtoToEntity(form);
        productRepository.save(product);
        return productMapper.mapEntityToDto(product);
    }

    public Object getAllProducts() {
        List<Product> allProductEntities = productRepository.findAll();
        return allProductEntities.stream()
                .map(product -> productMapper.mapEntityToDto(product))
                .collect(Collectors.toList());
    }

    public ProductDto findProductById(Long id) {
        Product product=productRepository.findById(id).orElseThrow(() -> new RuntimeException("Equipment not found"));
   return productMapper.mapEntityToDto(product);
    }

    public void deleteProduct(Long id) {
    Product product=productRepository.findById(id).orElseThrow(() -> new RuntimeException("Equipment not found"));
    productRepository.delete(product);
    }
}
