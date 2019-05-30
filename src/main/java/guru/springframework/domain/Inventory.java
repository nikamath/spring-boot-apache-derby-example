package guru.springframework.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Inventory {

  @Id
  @Column(name = "id")
  @GeneratedValue
  private Long id;

  @OneToMany(mappedBy = "inventory", orphanRemoval = true, cascade = CascadeType.ALL)
  private Set<Product> products = new HashSet<>();

  private String name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Set<Product> getProducts() {
    return products;
  }

  public String getName() {
  return name;}

  public void setName(String name) {
  this.name = name;}

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Inventory other = (Inventory) obj;
    if (name == null) {
      if (other.name != null) return false;
    } else if (!name.equals(other.name)) return false;
    return true;
  }

  /*public void setProducts(List<Product> products) {
  this.products.addAll(products);
  }*/

}
