package com.bobocode.petros.ticketservice.usecase;

import com.bobocode.petros.ticketservice.adapter.TicketGeneratorAdapter;
import com.bobocode.petros.ticketservice.entity.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GetTicketsUseCaseImpl implements GetTicketsUseCase {
    private final TicketGeneratorAdapter generatorService;

    @Override
    public List<Ticket> generate(String countryFrom, String countryTo, String cityFrom, String cityTo, LocalDate startDate, LocalDate endDate) {
        return generatorService.generateTicket(countryFrom, countryTo, cityFrom, cityTo, startDate, endDate);
    }
}
