package github.project.my.productsapi.repository;

import github.project.my.productsapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProducts extends JpaRepository<Product, String> {

}
