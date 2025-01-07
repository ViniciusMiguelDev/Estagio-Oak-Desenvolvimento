package br.com.oaktest.oaktest.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oaktest.oaktest.entity.Product;

public interface ProductRepository extends JpaRepository<Product, UUID>{

}
