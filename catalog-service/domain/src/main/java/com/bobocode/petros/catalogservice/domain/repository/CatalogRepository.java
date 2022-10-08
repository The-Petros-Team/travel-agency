package com.bobocode.petros.catalogservice.domain.repository;


import com.bobocode.petros.catalogservice.domain.enitity.Catalog;

import java.util.List;

public interface CatalogRepository {
    List<Catalog> getAllCatalogs();

    Catalog getCatalogByCountry(String country);
}
