package com.bobocode.ticketservice.generator.ticket.impl;

import com.bobocode.petros.ticketservice.entity.Ticket;
import com.bobocode.petros.ticketservice.entity.enumeration.FlightClass;
import com.bobocode.ticketservice.generator.date.DateGenerator;
import com.bobocode.ticketservice.generator.ticket.TicketGeneratorService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class TicketGeneratorServiceImpl implements TicketGeneratorService {
    @Override
    public List<Ticket> generate(String countryFrom, String countryTo, String cityFrom, String cityTo,
                                 com.google.protobuf.Timestamp startDate, com.google.protobuf.Timestamp endDate) {
        return IntStream.generate(() -> ThreadLocalRandom.current().nextInt(10, 100))
                .limit(5)
                .mapToObj(n -> Ticket.builder()
                        .flightClass(FlightClass.getRandomFlightClass())
                        .countryFrom(countryFrom + n)
                        .cityFrom(cityFrom + n)
                        .countryTo(countryTo + n)
                        .cityTo(cityTo + n)
                        .flightDate(DateGenerator.generate(startDate, endDate))
                        .price(ThreadLocalRandom.current().nextLong(1000))
                        .build()
                ).collect(Collectors.toList());
    }
}
