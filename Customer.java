package com.example;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    // Cascade so Professor is saved/deleted with Customer
    @OneToOne(mappedBy = "customer",
              cascade = CascadeType.ALL,
              orphanRemoval = true)
    private Professor professor;

    // Getters & setters

    public Integer getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Professor getProfessor() { return professor; }
    public void setProfessor(Professor professor) {
        this.professor = professor;
        if (professor != null) {
            professor.setCustomer(this);
        }
    }
}
