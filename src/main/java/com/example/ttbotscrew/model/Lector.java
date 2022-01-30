package com.example.ttbotscrew.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "lectors")
@Data
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    @Enumerated(value = EnumType.STRING)
    private Degree degree;
    @ManyToMany
    private List<Department> departments;
    private int salary;
}
