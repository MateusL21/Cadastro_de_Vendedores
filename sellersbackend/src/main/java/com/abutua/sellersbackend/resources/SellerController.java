package com.abutua.sellersbackend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.abutua.sellersbackend.models.Seller;
import com.abutua.sellersbackend.repositories.SellerRepository;

import java.net.URI;
import java.util.List;
import java.util.ArrayList;

@RestController
@CrossOrigin
public class SellerController {

    private List<Seller> sellers = new ArrayList<>();

    @Autowired
    private SellerRepository sellerRepository;

    @PostMapping("sellers")
    public ResponseEntity<Seller> save(@RequestBody Seller seller) {
        seller.setId((long)sellers.size() + 1);
        sellers.add(seller);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(seller.getId())
                .toUri();
 
        return ResponseEntity.created(location).body(seller);

    }

    @GetMapping("sellers/{id}")
    public ResponseEntity<Seller> getSeller(@PathVariable int id) {
        Seller prod = sellers.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Seller not found"));

        return ResponseEntity.ok(prod);
    }

    @GetMapping("sellers")
    public List<Seller> getSellers() {
        return sellerRepository.findAll();
    }
    
}

