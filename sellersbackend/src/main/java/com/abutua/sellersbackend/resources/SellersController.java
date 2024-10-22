package com.abutua.sellersbackend.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SellersController {

    @GetMapping("sellers")
    public String getSellers(){
        return "I am a seller";
    }
    
}
