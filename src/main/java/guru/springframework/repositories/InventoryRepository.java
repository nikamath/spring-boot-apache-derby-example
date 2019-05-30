package guru.springframework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import guru.springframework.domain.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long>{
  
}
