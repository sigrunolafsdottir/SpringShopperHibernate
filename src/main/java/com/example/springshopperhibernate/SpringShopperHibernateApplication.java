package com.example.springshopperhibernate;

import com.example.springshopperhibernate.shopping.models.BuyOrder;
import com.example.springshopperhibernate.shopping.models.Klubbmedlem;
import com.example.springshopperhibernate.shopping.models.Kund;
import com.example.springshopperhibernate.shopping.models.Product;
import com.example.springshopperhibernate.shopping.repositories.BuyOrderRepository;
import com.example.springshopperhibernate.shopping.repositories.KlubbmedlemRepository;
import com.example.springshopperhibernate.shopping.repositories.KundRepository;
import com.example.springshopperhibernate.shopping.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SpringShopperHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringShopperHibernateApplication.class, args);
    }


    //Denna metod kommer bara att köras om den har en @Bean-annotering
    //Fyller databasen före start
/*
    @Bean
    public CommandLineRunner demo(KlubbmedlemRepository klubbmedlemRepo,
                                  KundRepository kundRepo, BuyOrderRepository orderRepo) {
        return (args) -> {
            Kund k = new Kund("Nisse", "Drottninggatan 2");
            Kund k1 = new Kund("Bella", "Drottninggatan 3");
            Kund k2 = new Kund("Milla", "Drottninggatan 4");
            kundRepo.save(k1);

            Klubbmedlem km = new Klubbmedlem("123", k);
            klubbmedlemRepo.save(km);

            Product p1 = new Product("1", "skor");
            Product p2 = new Product("1", "strumpor");

            BuyOrder o = new BuyOrder("34", k1, Arrays.asList(p1, p2));
            orderRepo.save(o);
        };

    }

 */
}
