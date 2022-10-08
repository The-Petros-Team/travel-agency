package com.bobocode.petros.catalogservice.domain.usecase;


import com.bobocode.petros.catalogservice.domain.enitity.Catalog;

import java.util.List;

public interface GetCatalogUseCase {
    List<Catalog> getFullCatalog();

    Catalog getCatalogByCountry(String countryName);
}
