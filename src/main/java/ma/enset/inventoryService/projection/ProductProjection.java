package ma.enset.inventoryService.projection;

import ma.enset.inventoryService.entity.Product;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullProduct",types = Product.class)
public interface ProductProjection  extends Projection{
    public long getId();
    public String getName();
    public double getPrice();
}
