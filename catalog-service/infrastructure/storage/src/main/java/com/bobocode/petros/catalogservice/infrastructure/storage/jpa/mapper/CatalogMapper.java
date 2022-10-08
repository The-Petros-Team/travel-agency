package com.bobocode.petros.catalogservice.infrastructure.storage.jpa.mapper;

import com.bobocode.petros.catalogservice.domain.enitity.Catalog;
import com.bobocode.petros.catalogservice.infrastructure.storage.jpa.entity.CountryEntity;
import org.springframework.stereotype.Component;

@Component
public class CatalogMapper {
    public Catalog toDomainEntity(CountryEntity countryEntity) {
        return Catalog.builder()
                .country(countryEntity.getName())
                .cities(countryEntity.getCities())
                .build();
    }
}
