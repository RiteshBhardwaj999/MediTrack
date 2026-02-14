package com.airtribe.meditrack.util;

import com.airtribe.meditrack.constants.Constants;
import com.airtribe.meditrack.entity.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil {

    // ================== DOCTOR ==================

    public static void saveDoctors(List<Doctor> doctors) {

        File file = new File(Constants.DOCTOR_FILE);

        // create data folder automatically
        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(file))) {

            for (Doctor d : doctors) {
                writer.write(d.getId() + "," +
                        d.getName() + "," +
                        d.getAge() + "," +
                        d.getSpecialization() + "," +
                        d.getConsultationFee());
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void ensureDirectoryExists(String path) {
        File file = new File(path);
        File parent = file.getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }
    }


    public static List<Doctor> loadDoctors() {
        List<Doctor> doctors = new ArrayList<>();

        File file = new File(Constants.DOCTOR_FILE);
        if (!file.exists()) return doctors;

        try (BufferedReader reader = new BufferedReader(
                new FileReader(file))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                Doctor doctor = new Doctor(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        Integer.parseInt(parts[2]),
                        Specialization.valueOf(parts[3]),
                        Double.parseDouble(parts[4])
                );

                doctors.add(doctor);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return doctors;
    }

    // ================== PATIENT ==================

    public static void savePatients(List<Patient> patients) {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(Constants.PATIENT_FILE))) {

            for (Patient p : patients) {
                writer.write(p.getId() + "," +
                        p.getName() + "," +
                        p.getAge() + "," +
                        p.getDisease());
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Patient> loadPatients() {
        List<Patient> patients = new ArrayList<>();

        File file = new File(Constants.PATIENT_FILE);
        if (!file.exists()) return patients;

        try (BufferedReader reader = new BufferedReader(
                new FileReader(file))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                Patient patient = new Patient(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        Integer.parseInt(parts[2]),
                        parts[3]
                );

                patients.add(patient);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return patients;
    }

    // ================== APPOINTMENT ==================

    public static void saveAppointments(List<Appointment> appointments) {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(Constants.APPOINTMENT_FILE))) {

            for (Appointment a : appointments) {
                writer.write(a.getStatus() + "," +
                        a.getDoctor().getId() + "," +
                        a.getDoctor().getName() + "," +
                        a.getDoctor().getAge());
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
