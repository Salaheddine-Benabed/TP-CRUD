package com.salah.devoir_3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int requiredTime;
}
