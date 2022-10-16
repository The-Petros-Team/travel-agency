package com.bobocode.petros.ticketservice.usecase;

import com.bobocode.petros.ticketservice.entity.Ticket;



import java.time.LocalDate;
import java.util.List;

public interface GetTicketsUseCase {
    List<Ticket> generate(String countryFrom, String countryTo, String cityFrom, String cityTo,
                          LocalDate startDate, LocalDate endDate);
}
