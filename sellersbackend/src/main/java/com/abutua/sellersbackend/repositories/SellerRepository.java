package com.abutua.sellersbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abutua.sellersbackend.models.Seller;

public interface SellerRepository extends JpaRepository <Seller,Long>{
    
}
