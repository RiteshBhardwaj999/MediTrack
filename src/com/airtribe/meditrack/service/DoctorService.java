package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Doctor;
import com.airtribe.meditrack.util.CSVUtil;
import com.airtribe.meditrack.util.DataStore;

public class DoctorService {

    private DataStore<Doctor> doctorStore = new DataStore<>();

    public void addDoctor(Doctor doctor) {
        doctorStore.add(doctor);
        CSVUtil.saveDoctors(doctorStore.getAll());
    }

    public void viewDoctors() {
        doctorStore.getAll().forEach(Doctor::display);
    }

    public DataStore<Doctor> getDoctorStore() {
        return doctorStore;
    }

}
