package br.com.oaktest.oaktest.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.oaktest.oaktest.entity.Product;
import br.com.oaktest.oaktest.service.ProductService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping
    Product create(@RequestBody @Valid Product product) {
        return service.create(product);
    }

    @GetMapping
    List<Product> read() {
        return service.read();
    }

    @GetMapping("{id}")
    Product readById(@PathVariable("id") UUID id) {
        return service.readById(id);
    }

    @PutMapping("{id}")
    Product update(@PathVariable("id") UUID id, @RequestBody @Valid Product product) {
        return service.update(id, product);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable("id") UUID id) {
        service.delete(id);
    }
}
