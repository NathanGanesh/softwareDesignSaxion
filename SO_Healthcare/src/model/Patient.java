package model;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private String name;
    private char sex;
    private int age;
    private List<Appointment> appointments = new ArrayList<>();
    private List<Prescription> prescriptions = new ArrayList<>();

    public Patient(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public String getName() {
        return name;
    }

    public String toString(){
        String title = "Mr. ";
        if(sex == 'F'){
            title = "Mrs. ";
        }
        return title + name;
    }

    public Appointment[] getAppointments() {
        return appointments.toArray(new Appointment[0]);
    }

    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    public Prescription[] getPrescriptions(){
        return prescriptions.toArray(new Prescription[0]);
    }
}
