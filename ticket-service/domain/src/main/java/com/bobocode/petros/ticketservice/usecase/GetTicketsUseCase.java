package com.bobocode.petros.ticketservice.usecase;

import com.bobocode.petros.ticketservice.entity.Ticket;

import java.util.List;

public interface GetTicketsUseCase {
    //TODO rewrite accepted parameter to real
    List<Ticket> getTickets(String something);

    Ticket getTicket(String something);
}
