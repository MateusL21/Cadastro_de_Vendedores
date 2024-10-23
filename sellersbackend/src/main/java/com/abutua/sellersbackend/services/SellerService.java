package com.abutua.sellersbackend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.abutua.sellersbackend.models.Seller;
import com.abutua.sellersbackend.repositories.SellerRepository;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

        
    public Seller getById(Long id){
        Seller seller = sellerRepository.findById((long) id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Seller not found"));

                return seller;
    }

    public List <Seller> getAll(){
        return sellerRepository.findAll();
    }

    public Seller save(Seller seller){
        return sellerRepository.save(seller);
    }

    public void deleteById(Long id){

        Seller seller = getById(id);
        sellerRepository.delete(seller);
    }

    public void update(Long id, Seller sellerUpdate){
        Seller seller = getById(id);


        seller.setName(sellerUpdate.getName());
        seller.setGender(sellerUpdate.getGender());
        seller.setSalary(sellerUpdate.getSalary());
        seller.setBonus(sellerUpdate.getBonus());

        sellerRepository.save(seller);
    }
}
