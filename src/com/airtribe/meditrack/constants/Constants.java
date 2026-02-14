package com.airtribe.meditrack.constants;

import java.nio.file.Path;

public class Constants {

    public static final double TAX_RATE = 0.18;

    private static final Path DATA_DIR = Path.of(System.getProperty("user.dir"), "data");

    public static final String DOCTOR_FILE = DATA_DIR.resolve("doctors.csv").toString();
    public static final String PATIENT_FILE = DATA_DIR.resolve("patients.csv").toString();
    public static final String APPOINTMENT_FILE = DATA_DIR.resolve("appointments.csv").toString();

    static {
        System.out.println("Configuration Loaded...");
    }
}
