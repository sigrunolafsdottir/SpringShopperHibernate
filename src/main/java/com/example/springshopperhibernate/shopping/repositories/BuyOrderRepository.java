package com.example.springshopperhibernate.shopping.repositories;

import com.example.springshopperhibernate.shopping.models.BuyOrder;
import org.springframework.data.repository.CrudRepository;

public interface BuyOrderRepository extends CrudRepository<BuyOrder, Long> {

}