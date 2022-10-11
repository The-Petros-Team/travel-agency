package com.bobocode.petros.catalogservice.application.usecase.impl;

import com.bobocode.petros.catalogservice.domain.enitity.Catalog;
import com.bobocode.petros.catalogservice.domain.repository.CatalogRepository;
import com.bobocode.petros.catalogservice.domain.usecase.GetCatalogUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetCatalogUseCaseImpl implements GetCatalogUseCase {

    private final CatalogRepository catalogRepository;

    @Override
    public List<Catalog> getFullCatalog() {
        return catalogRepository.getAllCatalogs();
    }

    @Override
    public Catalog getCatalogByCountry(String countryName) {
        return catalogRepository.getCatalogByCountry(countryName);
    }
}
