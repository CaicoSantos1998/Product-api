package github.project.my.productsapi.controller;

import github.project.my.productsapi.model.Product;
import github.project.my.productsapi.repository.RepositoryProducts;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("products")
public class ProductController {

    private RepositoryProducts repositoryProducts;

    public ProductController(RepositoryProducts repositoryProducts){
        this.repositoryProducts = repositoryProducts;
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        System.out.println("Product received: " + product);

        var id = UUID.randomUUID().toString();

        product.setId(id);
        repositoryProducts.save(product);

        return product;
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable("id") String id) {
        //Optional<Product> productsById = repositoryProducts.findById(id);
        //return productsById.isPresent() ? productsById.get() : null;

        return  repositoryProducts.findById(id).orElse(null);
    }

}
