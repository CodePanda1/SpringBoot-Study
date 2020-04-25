package com.example.spring_phone_store.repository;

import com.example.spring_phone_store.entity.BuyerAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerAddressRepository extends JpaRepository<BuyerAddress,Integer> {
}
