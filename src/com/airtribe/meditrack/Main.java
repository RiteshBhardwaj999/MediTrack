package com.airtribe.meditrack;

import com.airtribe.meditrack.entity.*;
import com.airtribe.meditrack.service.*;
import com.airtribe.meditrack.util.CSVUtil;
import com.airtribe.meditrack.util.IdGenerator;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DoctorService doctorService = new DoctorService();
        PatientService patientService = new PatientService();
        AppointmentService appointmentService = new AppointmentService();
        IdGenerator idGen = IdGenerator.getInstance();
        doctorService.getDoctorStore()
                .getAll()
                .addAll(CSVUtil.loadDoctors());

        patientService.getPatientStore()
                .getAll()
                .addAll(CSVUtil.loadPatients());


        while (true) {

            System.out.println("\n--- MediTrack Menu ---");
            System.out.println("1. Add Doctor");
            System.out.println("2. Add Patient");
            System.out.println("3. Create Appointment");
            System.out.println("4. View Doctors");
            System.out.println("5. View Patients");
            System.out.println("6. View Appointments");
            System.out.println("0. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();

                    System.out.print("Name: ");
                    String dName = sc.nextLine();

                    System.out.print("Age: ");
                    int dAge = sc.nextInt();

                    System.out.print("Consultation Fee: ");
                    double fee = sc.nextDouble();

                    // 🔥 Show specialization options dynamically
                    System.out.println("Select Specialization:");
                    Specialization[] specs = Specialization.values();

                    for (int i = 0; i < specs.length; i++) {
                        System.out.println((i + 1) + ". " + specs[i]);
                    }

                    System.out.print("Enter choice: ");
                    int specChoice = sc.nextInt();

                    // Validate choice
                    if (specChoice < 1 || specChoice > specs.length) {
                        System.out.println("Invalid specialization choice!");
                        break;
                    }

                    Specialization selectedSpec = specs[specChoice - 1];

                    Doctor doctor = new Doctor(
                            idGen.generateId(),
                            dName,
                            dAge,
                            selectedSpec,
                            fee
                    );

                    doctorService.addDoctor(doctor);

                    System.out.println("Doctor added successfully!");
                    break;
                case 2:
                    sc.nextLine();
                    System.out.print("Name: ");
                    String pName = sc.nextLine();
                    System.out.print("Age: ");
                    int pAge = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Disease: ");
                    String disease = sc.nextLine();

                    Patient patient = new Patient(
                            idGen.generateId(),
                            pName,
                            pAge,
                            disease
                    );

                    patientService.addPatient(patient);
                    break;

                case 3:
                    if (doctorService.getDoctorStore().getAll().isEmpty() ||
                            patientService.getPatientStore().getAll().isEmpty()) {
                        System.out.println("Add doctor and patient first!");
                        break;
                    }

                    Appointment appointment = new Appointment(
                            idGen.generateId(),
                            patientService.getPatientStore().getAll().getFirst(),
                            doctorService.getDoctorStore().getAll().getFirst(),
                            LocalDate.now()
                    );

                    appointment.confirm();
                    appointmentService.createAppointment(appointment);
                    break;

                case 4:
                    doctorService.viewDoctors();
                    break;

                case 5:
                    patientService.viewPatients();
                    break;

                case 6:
                    appointmentService.viewAppointments();
                    break;

                case 0:
                    System.exit(0);
            }
        }
    }
}
