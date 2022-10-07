package com.bobocode.petros.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Embeddable
public class ReservationTicket {
    @Column(name = "reservation_id", nullable = false)
    private Long reservationId;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String city;
    @Column(name = "fligh_date", nullable = false)
    private LocalDate flightDate;
    @Column(nullable = false)
    private BigDecimal price;
}
