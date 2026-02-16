package com.example.chithanhd288.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
    private String country_name;

    @CreationTimestamp
    @Column(name="create_date")
    private LocalDateTime create_date;

    @UpdateTimestamp
    @Column(name="last_update")
    private LocalDateTime last_update;

    @OneToMany(mappedBy="country",cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private Set<Division> divisions;
}
