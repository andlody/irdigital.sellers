package com.irdigital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.irdigital.jpa.Seller;

public interface ISellerRepository extends JpaRepository<Seller,Integer>{

}