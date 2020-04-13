package com.example.springboot_1.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Student {
    @Id
    private String Sno;
    private String Sname;
    private String Ssex;
}
