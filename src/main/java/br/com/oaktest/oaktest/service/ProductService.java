package br.com.oaktest.oaktest.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.oaktest.oaktest.entity.Product;
import br.com.oaktest.oaktest.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product create(Product product) {
        repository.save(product);
        return product;
    }

    public List<Product> read() {
        return repository.findAll();
    }

    public Product readById(UUID id) {
        Optional<Product> optionalProduct = repository.findById(id);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            return existingProduct;
        } else {
            throw new RuntimeException("Produto não encontrado para o ID: " + id);
        }
    }

    public Product update(UUID id, Product product) {
        Optional<Product> optionalProduct = repository.findById(id);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setForSale(product.getForSale());
            return repository.save(existingProduct);
        } else {
            throw new RuntimeException("Produto não encontrado para o ID: " + id);
        }
    }

    public void delete(UUID id) {
        Optional<Product> optionalProduct = repository.findById(id);
        if (optionalProduct.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("Produto não encontrado para o ID: " + id);
        }
    }
}
