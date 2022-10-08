package com.bobocode.petros.catalogservice.domain.enitity;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Catalog {
    private String country;
    private List<String> cities;
}
