package net.javaguides.springboot.controller;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Product;
import net.javaguides.springboot.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductRepo productRepo;

    @GetMapping
    public List<Product> getAllProduct(){
        return productRepo.findAll();
    }

    // build create product REST API
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepo.save(product);
    }

    // build get product by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable  long id){
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not exist with id:" + id));
        return ResponseEntity.ok(product);
    }

    // build update product REST API
    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id,@RequestBody Product productDetails) {
        Product updateProduct = productRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not exist with id: " + id));

        updateProduct.setName(productDetails.getName());
        //updateProduct.setLastName(employeeDetails.getLastName());
        updateProduct.setPrice(productDetails.getPrice());

        productRepo.save(updateProduct);

        return ResponseEntity.ok(updateProduct);
    }

    // build delete product REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable long id){

        Product product = productRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not exist with id: " + id));

        productRepo.delete(product);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
