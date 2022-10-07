package com.bobocode.petros.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = "reservation")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String city;
    @Column(name = "hotel_name", nullable = false)
    private String hotelName;
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;
    @Column(nullable = false)
    private BigDecimal price;
    @Setter(AccessLevel.PRIVATE)
    @ElementCollection
    @CollectionTable(name = "reservation_ticket", joinColumns = @JoinColumn(name = "reservation_id"))
    private Collection<ReservationTicket> reservationTicket;
}
