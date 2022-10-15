package com.bobocode.ticketservice.generator.ticket;

import com.bobocode.petros.ticketservice.entity.Ticket;


import com.google.protobuf.Timestamp;
import java.util.List;

public interface TicketGeneratorService {
    List<Ticket> generate(String countryFrom, String countryTo, String cityFrom, String cityTo,
                          Timestamp startDate, Timestamp endDate);
}
