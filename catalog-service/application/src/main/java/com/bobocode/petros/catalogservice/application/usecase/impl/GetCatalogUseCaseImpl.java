package com.bobocode.petros.catalogservice.application.usecase.impl;

import com.bobocode.petros.catalogservice.domain.enitity.Catalog;
import com.bobocode.petros.catalogservice.domain.usecase.GetCatalogUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetCatalogUseCaseImpl implements GetCatalogUseCase {


    @Override
    public List<Catalog> getFullCatalog() {
        return null;
    }

    @Override
    public Catalog getCatalogByCountry(String countryName) {
        return null;
    }
}
