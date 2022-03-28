package com.example.springshopperhibernate.shopping.controllers;

import com.example.springshopperhibernate.shopping.models.Klubbmedlem;
import com.example.springshopperhibernate.shopping.models.Kund;
import com.example.springshopperhibernate.shopping.repositories.KlubbmedlemRepository;
import com.example.springshopperhibernate.shopping.repositories.KundRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/klubbmedlem")
public class KlubbmedlemController {

    private static final Logger log = LoggerFactory.getLogger(KlubbmedlemController.class);

    @Autowired
    private KundRepository kundRepository;
    @Autowired
    private KlubbmedlemRepository klubbmedlemRepository;

    @RequestMapping("/add")
    public String addNewKlubbmedlem(@RequestParam String medlemsnummer, @RequestParam long kund) {

        Klubbmedlem km = new Klubbmedlem();
        km.setMedlemsnummer(medlemsnummer);

        Kund k= kundRepository.findById(kund).get();
        if (k != null) {
            km.setKund(k);
        }

        klubbmedlemRepository.save(km);
        log.info("Klubbmedlem "+ medlemsnummer + " was added to database");
        return "Klubbmedlem "+ medlemsnummer + " is Saved";
    }


    @RequestMapping("/all")
    public Iterable<Klubbmedlem> getAllKlubbmedlem() {
        return klubbmedlemRepository.findAll();
    }

    @RequestMapping("/getById")
    public Klubbmedlem getKMById(@RequestParam Long id) {
        return klubbmedlemRepository.findById(id).get();
    }


}
