package com.bobocode.petros.catalogservice.infrastructure.storage.jpa.entity;


import lombok.Data;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "countries")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ElementCollection
    @CollectionTable(name = "cities", joinColumns = {@JoinColumn(name = "country_id")})
    @Column(name = "name")
    private List<String> cities = new ArrayList<>();
}
