package com.airtribe.meditrack.entity;
import java.io.Serializable;

public class Patient extends Person implements Cloneable, Serializable {

    private String disease;

    public Patient(int id, String name, int age, String disease) {
        super(id, name, age);
        this.disease = disease;
    }

    public String getDisease() {
        return disease;
    }

    @Override
    public Patient clone() {
        try {
            return (Patient) super.clone(); // deep safe (no nested objects)
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void display() {
        System.out.println("Patient ID: " + id +
                ", Name: " + name +
                ", Disease: " + disease);
    }
}
