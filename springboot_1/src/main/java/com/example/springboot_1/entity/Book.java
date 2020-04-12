package com.example.springboot_1.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Book {
    @Id//表明主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
    private Integer id;
    private String name;
    private String author;
}
