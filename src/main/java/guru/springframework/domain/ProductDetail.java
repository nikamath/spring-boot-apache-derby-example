package guru.springframework.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class ProductDetail implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = 8676804150260094044L;

  @Id
  private Long id;
  
  
  @OneToOne
  @MapsId
  @JoinColumn(name = "nikita", referencedColumnName = "id")
  private Product product;

  private String name;

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }


}
