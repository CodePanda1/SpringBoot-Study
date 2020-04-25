package com.example.spring_phone_store.repository;

import com.example.spring_phone_store.entity.PhoneCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneCategoryRepository extends JpaRepository<PhoneCategory, Integer> {
    public PhoneCategory findByCategoryType(Integer categoryType);
}
