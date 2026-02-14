package com.example.chithanhd288.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name="countries")
@Getter
@Setter


public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="country_id")
    private Long id;

    @Column(name="country")
    private String country;

    @Column(name="create_date")
    private LocalDateTime createDate;

    @Column(name="last_update")
    private LocalDateTime lastUpdate;

    @OneToMany(mappedBy="country",cascade=CascadeType.ALL)
    private Set<Division> divisions;
}
