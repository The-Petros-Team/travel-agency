package com.bobocode.petros.ticketservice.adapter;

import com.bobocode.petros.ticketservice.entity.Ticket;

import java.time.LocalDate;
import java.util.List;

public interface TicketGeneratorAdapter {
    List<Ticket> generateTicket(String countryFrom, String countryTo, String cityFrom, String cityTo,
                                LocalDate startDate, LocalDate endDate);
}
