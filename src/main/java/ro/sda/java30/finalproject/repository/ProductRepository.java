package ro.sda.java30.finalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.java30.finalproject.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
