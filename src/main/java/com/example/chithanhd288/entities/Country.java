package com.example.chithanhd288.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="countries")
@Getter
@Setter


public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="country_id")
    private Long id;

    private String country;

    @OneToMany(mappedBy="country")
    private Set<Division> divisions;
}
