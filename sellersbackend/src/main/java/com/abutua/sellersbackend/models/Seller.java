package com.abutua.sellersbackend.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TBL_SELLERS")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double salary;

    private Double bonus;

    private Integer gender; 

    public Seller(Long id, String name, Double salary, Double bonus, Integer gender) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.bonus = bonus;
        this.gender = gender;
    }

    public Seller(){

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getSalary() {
        return salary;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public Double getBonus() {
        return bonus;
    }
    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }
    public Integer getGender() {
        return gender;
    }
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    
}
