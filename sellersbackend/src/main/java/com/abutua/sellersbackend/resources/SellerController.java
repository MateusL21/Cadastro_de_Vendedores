package com.abutua.sellersbackend.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.abutua.sellersbackend.models.Seller;
import com.abutua.sellersbackend.services.SellerService;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping("sellers")
    public ResponseEntity<Seller> save(@RequestBody Seller seller) {

        seller = sellerService.save(seller);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(seller.getId())
                .toUri();
 
        return ResponseEntity.created(location).body(seller);

    }

    @GetMapping("sellers/{id}")
    public ResponseEntity<Seller> getSeller(@PathVariable Long id) {
        Seller seller = sellerService.getById(id);
        return ResponseEntity.ok(seller);
    }

    @GetMapping("sellers")
    public List<Seller> getSellers() {
        return sellerService.getAll();
    }

    @DeleteMapping("sellers/{id}")
    public ResponseEntity<Void> removeSeller(@PathVariable Long id) {
        sellerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("sellers/{id}")
    public ResponseEntity<Void> updateSeller(@PathVariable Long id, @RequestBody Seller sellerUpdate) {
        sellerService.update(id, sellerUpdate);
        return ResponseEntity.ok().build();
    }
    
}

