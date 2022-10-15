package com.bobocode.petros.ticketservice.usecase;

import com.bobocode.petros.ticketservice.entity.Ticket;
import com.bobocode.ticketservice.generator.ticket.TicketGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetTicketsUseCaseImpl implements GetTicketsUseCase{
    private final TicketGeneratorService generatorService;

    @Override
    public List<Ticket> getTickets(String something) {
        return null;
    }

    @Override
    public Ticket getTicket(String something) {
        return null;
    }
}
