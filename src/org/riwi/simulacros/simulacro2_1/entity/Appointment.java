package org.riwi.simulacros.simulacro2_1.entity;

import java.sql.Time;
import java.util.Date;

public class Appointment {
    private int id;
    private int doctorId;
    private int patientId;
    private Date date;
    private Time time;
    private String reason;
    private Doctor doctor;
    private Patient patient;

    public Appointment() {
    }

    public Appointment(int doctorId, int patientId, Date date, Time time, String reason) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.date = date;
        this.time = time;
        this.reason = reason;
    }

    public Appointment(int id, int doctorId, int patientId, Date date, Time time, String reason) {
        this.id = id;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.date = date;
        this.time = time;
        this.reason = reason;
    }

    public Appointment(int id, int doctorId, int patientId, Date date, Time time, String reason, Doctor doctor, Patient patient) {
        this.id = id;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.date = date;
        this.time = time;
        this.reason = reason;
        this.doctor = doctor;
        this.patient = patient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                ", date=" + date +
                ", time=" + time +
                ", reason='" + reason + '\'' +
                ", doctor=" + doctor +
                ", patient=" + patient +
                '}';
    }
}
