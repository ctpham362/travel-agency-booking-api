package com.example.chithanhd288.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "divisions")
@Getter
@Setter

public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long id;

    @Column(name = "division")
    private String division_name;

    @CreationTimestamp
    @Column(name = "create_date")
    private LocalDateTime create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    private LocalDateTime last_update;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false, insertable = false, updatable = false)
    private Country country;

    @OneToMany(mappedBy = "division", cascade=CascadeType.ALL)
    private Set<Customer> customers;

    @Column(name = "country_id")
    private long country_id;
    public void setCountry(Country country) {
        setCountry_id(country.getId());
        this.country = country;
    }

}
