package ma.enset.inventoryService.web;

import jakarta.ws.rs.Path;
import ma.enset.inventoryService.entity.Product;
import ma.enset.inventoryService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductRestControllerApi {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/products/{id}")
    private Optional<Product> getproProduct(@PathVariable long id){
        return Optional.of(productRepository.findById(id).get());
    }
    @GetMapping("/products")
    private List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    @PostMapping("/products")
    private Product saveProduct(@RequestBody Product product){
        return productRepository.save(product);
    }
    @PutMapping("/products")
    private Product updateProduct(@RequestBody Product product,@PathVariable long id){
        return productRepository.findById((long)id)
                .map(p->{
                    p.setName(product.getName());
                    p.setPrice(product.getPrice());
                    return productRepository.save(p);
                })
                .orElseThrow(() -> new IllegalArgumentException("Invalide Id"+id));
    }
    @DeleteMapping("/products")
    private void deleProduct(@PathVariable long id){
         productRepository.deleteById(id);
    }
}