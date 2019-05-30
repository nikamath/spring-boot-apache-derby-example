package guru.springframework.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Product {
  @Column(name = "id")
  @javax.persistence.Id
  @GeneratedValue
  private Long id;

  @Column(name = "description")
  private String description;

  @OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
  private ProductDetail productDetail;

  @ManyToOne
  @JoinColumn(name = "inventory_id", referencedColumnName = "id")
  private Inventory inventory;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProductDetail getProductDetail() {
    return productDetail;
  }

  public void setProductDetail(ProductDetail productDetail) {
    this.productDetail = productDetail;
    this.productDetail.setProduct(this);
  }
  
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((description == null) ? 0 : description.hashCode());
    result = prime * result + ((productDetail == null) ? 0 : productDetail.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Product other = (Product) obj;
    if (description == null) {
      if (other.description != null) return false;
    } else if (!description.equals(other.description)) return false;
    if (productDetail == null) {
      if (other.productDetail != null) return false;
    } else if (!productDetail.equals(other.productDetail)) return false;
    return true;
  }

  public Inventory getInventory() {
    return inventory;
  }

  public void setInventory(Inventory inventory) {
    this.inventory = inventory;
  }
}
