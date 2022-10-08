package com.bobocode.petros.catalogservice.infrastructure.storage.repository;

import com.bobocode.petros.catalogservice.domain.enitity.Catalog;
import com.bobocode.petros.catalogservice.domain.repository.CatalogRepository;
import com.bobocode.petros.catalogservice.infrastructure.storage.jpa.mapper.CatalogMapper;
import com.bobocode.petros.catalogservice.infrastructure.storage.jpa.repository.CountryEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CatalogRepositoryImpl implements CatalogRepository {
    private final CountryEntityRepository countryEntityRepository;
    private final CatalogMapper catalogMapper;

    @Override
    public List<Catalog> getAllCatalogs() {
        return countryEntityRepository.findAll()
                .stream()
                .map(catalogMapper::toDomainEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Catalog getCatalogByCountry(String country) {
        return countryEntityRepository.findByName(country)
                .map(catalogMapper::toDomainEntity)
                .orElseThrow();
    }
}
