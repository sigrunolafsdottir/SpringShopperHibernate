package com.example.springshopperhibernate.shopping.repositories;

import com.example.springshopperhibernate.shopping.models.Kund;
import com.example.springshopperhibernate.shopping.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}