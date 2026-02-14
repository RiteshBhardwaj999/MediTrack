package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Appointment;
import com.airtribe.meditrack.util.DataStore;

public class AppointmentService {

    private DataStore<Appointment> appointmentStore = new DataStore<>();

    public void createAppointment(Appointment appointment) {
        appointmentStore.add(appointment);
    }

    public void viewAppointments() {
        appointmentStore.getAll().forEach(Appointment::display);
    }
}
