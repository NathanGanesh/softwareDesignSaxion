package database;

import model.Patient;

import java.util.HashMap;
import java.util.Map;

public class PatientDB {
    private static Map<String, Patient> patients = new HashMap<>();

    public  Patient insertPatient(String name, char sex, int age) {
        Patient patient = new Patient(name, sex, age);
        patients.put(name, patient);
        return patient;
    }

    public  Patient findPatient(String patName) {
        return patients.get(patName);
    }
}
