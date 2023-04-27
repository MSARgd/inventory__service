package ma.enset.inventoryService;
import ma.enset.inventoryService.entity.Product;
import ma.enset.inventoryService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.UUID;
@SpringBootApplication
public class InventoryServiceApplication implements CommandLineRunner {
	@Autowired
	private ProductRepository productRepository;
	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		for (int i=1;i<=10;i++){
			productRepository.save(Product.builder()
							.id((long)i)
							.name(UUID.randomUUID().toString().substring(1,20).replaceAll("[^a-z]",""))
							.price(Math.random()*100)
							.build());
		}
	}
}