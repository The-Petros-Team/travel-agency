CREATE TABLE IF NOT EXISTS reservation
(
    id         BIGSERIAL,
    country    TEXT    NOT NULL,
    city       TEXT    NOT NULL,
    hotel_name TEXT    NOT NULL,
    start_date DATE    NOT NULL,
    end_date   DATE    NOT NULL,
    price      DECIMAL NOT NULL,
    CONSTRAINT reservation_PK PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS reserved_ticket
(
    class          TEXT    NOT NULL,
    country        TEXT    NOT NULL,
    city           TEXT    NOT NULL,
    flight_date    DATE    NOT NULL,
    price          DECIMAL NOT NULL,
    reservation_id BIGINT  NOT NULL,
    CONSTRAINT reserved_ticket_reservation_FK FOREIGN KEY (reservation_id) REFERENCES reservation (id)
);