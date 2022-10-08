package com.bobocode.petros.catalogservice.infrastructure.storage.jpa.repository;

import com.bobocode.petros.catalogservice.infrastructure.storage.jpa.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CountryEntityRepository extends JpaRepository<CountryEntity, Long> {
    @Query("select distinct c from CountryEntity c left join fetch c.cities")
    List<CountryEntity> findAll();

    @Query("select distinct c from CountryEntity c left join fetch c.cities where c.name=:name")
    Optional<CountryEntity> findByName(String name);
}
