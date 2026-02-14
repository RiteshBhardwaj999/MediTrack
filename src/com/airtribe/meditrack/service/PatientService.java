package com.airtribe.meditrack.service;

import com.airtribe.meditrack.entity.Patient;
import com.airtribe.meditrack.util.CSVUtil;
import com.airtribe.meditrack.util.DataStore;

public class PatientService {

    private DataStore<Patient> patientStore = new DataStore<>();

    public void addPatient(Patient patient) {
        patientStore.add(patient);
        CSVUtil.savePatients(patientStore.getAll());
    }

    public void viewPatients() {
        patientStore.getAll().forEach(Patient::display);
    }

    public DataStore<Patient> getPatientStore() {
        return patientStore;
    }
}
