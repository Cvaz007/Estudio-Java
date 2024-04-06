package org.riwi.simulacros.simulacro2_2.entity;

import java.util.Date;

public class Reservation {
    private int id;
    private int flightId;
    private int passengerId;
    private String seat;
    private Date reservationDate;
    private Passenger passenger;
    private Flight flight;

    public Reservation() {
    }

    public Reservation(int flightId, int passengerId, String seat, Date reservationDate) {
        this.flightId = flightId;
        this.passengerId = passengerId;
        this.seat = seat;
        this.reservationDate = reservationDate;
    }

    public Reservation(int id, int flightId, int passengerId, String seat, Date reservationDate, Passenger passenger, Flight flight) {
        this.id = id;
        this.flightId = flightId;
        this.passengerId = passengerId;
        this.seat = seat;
        this.reservationDate = reservationDate;
        this.passenger = passenger;
        this.flight = flight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", flightId=" + flightId +
                ", passengerId=" + passengerId +
                ", seat='" + seat + '\'' +
                ", reservationDate=" + reservationDate +
                ", passenger=" + passenger.toString() +
                ", flight=" + flight.toString() +
                '}';
    }
}
