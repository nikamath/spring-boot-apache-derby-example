package guru.springframework;

import java.util.Arrays;
import java.util.Optional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import guru.springframework.domain.Inventory;
import guru.springframework.domain.Product;
import guru.springframework.domain.ProductDetail;
import guru.springframework.repositories.InventoryRepository;
import guru.springframework.repositories.ProductRepository;

@SpringBootApplication
public class SpringBootDerbyApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootDerbyApplication.class, args);
  }

  @Bean
  public CommandLineRunner run(InventoryRepository inRepo, ProductRepository prodRepo) {
    return args -> {
      Inventory in = new Inventory();
      in.setName("nikita");
      Product product = new Product();
      ProductDetail detail = new ProductDetail();
      detail.setName("detail");
      product.setDescription("abc");
      product.setProductDetail(detail);
      in.getProducts().add(product);
      product.setInventory(in);
      inRepo.save(in);

      Product product1 = new Product();
      ProductDetail detail1 = new ProductDetail();
      detail1.setName("detail1");
      product1.setDescription("xyz");
      in.getProducts().add(product1);
      product1.setInventory(in);
      Inventory save = inRepo.save(in);
      inRepo.getOne(in.getId());
      Product findFirst =
          save.getProducts()
              .stream()
              .filter(
                  p -> {
                    return p.getDescription().equals("xyz");
                  })
              .findFirst()
              .orElse(null);
      findFirst.setProductDetail(detail1);
      inRepo.save(save);
    };
  }
}
