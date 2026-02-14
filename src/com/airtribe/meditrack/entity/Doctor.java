package com.airtribe.meditrack.entity;
import java.io.Serializable;

public class Doctor extends Person implements Serializable {

    private Specialization specialization;
    private double consultationFee;

    public Doctor(int id, String name, int age,
                  Specialization specialization,
                  double consultationFee) {
        super(id, name, age);
        this.specialization = specialization;
        this.consultationFee = consultationFee;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    @Override
    public void display() {
        System.out.println("Doctor ID: " + id +
                ", Name: " + name +
                ", Specialization: " + specialization +
                ", Fee: " + consultationFee);
    }
}
