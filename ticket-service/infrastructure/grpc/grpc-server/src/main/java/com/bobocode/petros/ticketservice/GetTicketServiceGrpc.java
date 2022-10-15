package com.bobocode.petros.ticketservice;

import com.bobocode.petros.ticketservice.entity.Ticket;
import com.bobocode.petros.ticketservice.proto.MultipleTicketResponse;
import com.bobocode.petros.ticketservice.proto.TicketRequest;
import com.bobocode.petros.ticketservice.proto.TicketResponse;
import com.bobocode.petros.ticketservice.proto.TicketServiceGrpc;
import com.bobocode.ticketservice.generator.ticket.TicketGeneratorService;
import com.google.protobuf.Timestamp;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@GrpcService
@Service
@RequiredArgsConstructor
public class GetTicketServiceGrpc extends TicketServiceGrpc.TicketServiceImplBase {

    private final TicketGeneratorService ticketGeneratorService;

    @Override
    public void getTickets(TicketRequest request, StreamObserver<MultipleTicketResponse> responseObserver) {
        var response = MultipleTicketResponse.newBuilder().addAllTickets(ticketGeneratorService.generate(request.getCountryFrom(), request.getCountryTo(),
                                request.getCityFrom(), request.getCityTo(), request.getStartDate(), request.getEndDate())
                        .stream()
                        .map(this::toTicketResponse)
                        .collect(Collectors.toList()))
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private TicketResponse toTicketResponse(Ticket ticket) {
        return TicketResponse.newBuilder()
                .setClass_(ticket.getFlightClass().name())
                .setCountryFrom(ticket.getCountryFrom())
                .setCityFrom(ticket.getCityFrom())
                .setCountryTo(ticket.getCountryTo())
                .setCityTo(ticket.getCityTo())
                .setFlightDate(Timestamp.newBuilder()
                        .setSeconds(ticket.getFlightDate().toEpochDay())
                        .build())
                .setPrice(ticket.getPrice())
                .build();
    }
}
