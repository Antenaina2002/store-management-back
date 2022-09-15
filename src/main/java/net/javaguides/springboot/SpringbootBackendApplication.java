package net.javaguides.springboot;

import net.javaguides.springboot.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private ProductRepo productRepo;

	@Override
	public void run(String... args) throws Exception {
		/*Product product = new Product();
		product.setName("Oreo");
		product.setPrice("5 $");
		productRepo.save(product);

		Product product1 = new Product();
		product1.setName("Toothpaste");
		product1.setPrice("2,50 $");
		productRepo.save(product1);*/
	}
}
