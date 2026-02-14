package com.airtribe.meditrack.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Appointment implements Serializable {

    private int appointmentId;
    private Patient patient;
    private Doctor doctor;
    private LocalDate date;
    private AppointmentStatus status;

    public Appointment(int appointmentId, Patient patient,
                       Doctor doctor, LocalDate date) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.status = AppointmentStatus.PENDING;
    }

    public void confirm() {
        this.status = AppointmentStatus.CONFIRMED;
    }

    public void cancel() {
        this.status = AppointmentStatus.CANCELLED;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void display() {
        System.out.println("Appointment ID: " + appointmentId +
                ", Patient: " + patient.getName() +
                ", Doctor: " + doctor.getName() +
                ", Date: " + date +
                ", Status: " + status);
    }
}
