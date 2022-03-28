package com.example.springshopperhibernate.shopping.controllers;

import com.example.springshopperhibernate.shopping.models.Kund;
import com.example.springshopperhibernate.shopping.repositories.KundRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/kund")
public class KundController {

    @Autowired
    private KundRepository kundRepository;

    @RequestMapping( "/add")
    public String addNewKund(@RequestParam String name, @RequestParam (required=false) String adress) {

        Kund n = new Kund();
        n.setName(name);
        n.setAdress(adress);
        kundRepository.save(n);
        return name + " is Saved";
    }

    @RequestMapping("/all")
    public Iterable<Kund> getAll() {
        Iterable<Kund> k = kundRepository.findAll();
        return k;
    }

    @RequestMapping("/getById")
    public Kund getKundById(@RequestParam Long id) {

        return kundRepository.findById(id).get();
    }


}
