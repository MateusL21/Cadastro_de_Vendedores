package com.abutua.sellersbackend.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abutua.sellersbackend.models.Sellers;

@RestController
public class SellersController {

    @GetMapping("sellers")
    public Sellers getSellers(){

        Sellers s = new Sellers();

        return s;
    }
    
}
