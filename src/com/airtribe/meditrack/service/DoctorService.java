package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Doctor;
import com.airtribe.meditrack.entity.Specialization;
import com.airtribe.meditrack.util.CSVUtil;
import com.airtribe.meditrack.util.DataStore;

import java.util.List;
import java.util.stream.Collectors;

public class DoctorService {

    private DataStore<Doctor> doctorStore = new DataStore<>();

    public void addDoctor(Doctor doctor) {
        doctorStore.add(doctor);
        CSVUtil.saveDoctors(doctorStore.getAll());
    }

    public List<Doctor> searchBySpecialization(Specialization specialization) {
        return doctorStore.getAll()
                .stream()
                .filter(d -> d.getSpecialization() == specialization)
                .collect(Collectors.toList());
    }

    public void viewDoctors() {
        doctorStore.getAll().forEach(Doctor::display);
    }

    public DataStore<Doctor> getDoctorStore() {
        return doctorStore;
    }

}
