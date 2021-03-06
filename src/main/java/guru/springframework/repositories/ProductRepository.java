package guru.springframework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import guru.springframework.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}
