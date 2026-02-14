MediTrack — Clinic & Appointment Management System
📌 Overview

MediTrack is a modular, object-oriented Clinic & Appointment Management System built using Core Java.

The project simulates real-world healthcare management by handling:

Doctors

Patients

Appointments

Billing

Data Persistence (CSV + Serialization)

It demonstrates strong understanding of:

Core Java

OOP principles

JVM concepts

File handling

Design patterns

Collections & Generics

🚀 Features
👨‍⚕ Doctor Management

Add and view doctors

Select specialization using Enum

Consultation fee handling

Persistent storage

🧑 Patient Management

Add and view patients

Cloneable implementation

Persistent storage

📅 Appointment Management

Create appointments

Confirm / Cancel appointments

Uses AppointmentStatus Enum

Links doctor & patient objects

💰 Billing

Tax calculation via constants

Immutable BillSummary class

Strategy-ready billing design

💾 Data Persistence

CSV file storage (acts like lightweight database)

Java Serialization support

Auto-save functionality

try-with-resources implementation

Automatic folder creation

🧠 Concepts Implemented
Core OOP

Encapsulation

Inheritance

Polymorphism

Abstraction

Advanced OOP

Immutable class

Enums

Cloneable

Static initialization blocks

Java Features

Collections Framework (ArrayList, HashMap)

Generics (DataStore<T>)

AtomicInteger (Thread-safe ID generation)

Custom Exceptions

Streams (optional analytics)

Design Patterns

Singleton (IdGenerator)

Strategy-ready billing structure

Factory-ready architecture



🏗 Project Structure
com.airtribe.meditrack
│
├── Main.java
├── constants/
├── entity/
├── service/
├── util/
├── exception/
├── interface/
└── test/

🛠 Tech Stack

Java 8+

IntelliJ IDEA

Git & GitHub

Core Java Libraries

File I/O (BufferedReader / BufferedWriter)

Java Serialization

▶ How to Run
1️⃣ Clone the repository
git clone https://github.com/yourusername/MediTrack.git

2️⃣ Open in IntelliJ

Open the project folder.

3️⃣ Ensure data/ folder exists

If not, it will be created automatically when program runs.

4️⃣ Run Main.java
📂 Data Storage

Data is stored in:

data/
    doctors.csv / doctors.ser
    patients.csv / patients.ser
    appointments.csv / appointments.ser


This allows data persistence even after restarting the application.
