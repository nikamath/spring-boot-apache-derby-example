package guru.springframework.domain;

import java.io.Serializable;

public class ProductDetailPK implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = 7874762023313593540L;
  
  private Product product;
  private String name;
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((product == null) ? 0 : product.hashCode());
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    ProductDetailPK other = (ProductDetailPK) obj;
    if (name == null) {
      if (other.name != null) return false;
    } else if (!name.equals(other.name)) return false;
    if (product == null) {
      if (other.product != null) return false;
    } else if (!product.equals(other.product)) return false;
    return true;
  }
  
}
