package com.bobocode.petros.catalogservice.rest.controller;

import com.bobocode.petros.catalogservice.domain.usecase.GetCatalogUseCase;
import com.bobocode.petros.openapi.controller.CatalogApi;
import com.bobocode.petros.openapi.model.CatalogDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CatalogController implements CatalogApi {
    private final GetCatalogUseCase getCatalogUseCase;

    @Override
    public ResponseEntity<List<CatalogDto>> getAllCatalogs() {
        return ResponseEntity.ok(getCatalogUseCase.getFullCatalog().stream()
                .map(catalog -> new ModelMapper().map(catalog, CatalogDto.class))
                .toList());
    }
}
