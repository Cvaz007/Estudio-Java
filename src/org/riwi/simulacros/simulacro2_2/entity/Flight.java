package org.riwi.simulacros.simulacro2_2.entity;

import java.sql.Time;
import java.util.Date;

public class Flight {
    private int id;
    private String destination;
    private Date start;
    private Time time;
    private int airplaneId;

    public Flight() {
    }

    public Flight(String destination, Date start, Time time, int airplaneId) {
        this.destination = destination;
        this.start = start;
        this.time = time;
        this.airplaneId = airplaneId;
    }

    public Flight(int id, String destination, Date start, Time time, int airplaneId) {
        this.id = id;
        this.destination = destination;
        this.start = start;
        this.time = time;
        this.airplaneId = airplaneId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", destination='" + destination + '\'' +
                ", start=" + start +
                ", time=" + time +
                ", airplaneId=" + airplaneId +
                '}';
    }
}
