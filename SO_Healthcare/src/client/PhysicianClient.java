package client;

import database.MedicineDB;
import database.PatientDB;
import database.PhysicianDB;
import facade.HealthCareFacade;
import model.*;

public class PhysicianClient {

    HealthCareFacade healthCareFacade;

    public PhysicianClient(HealthCareFacade facade) {
        this.healthCareFacade = facade;
    }

    public void runSimulation() {

        System.out.println("Simulation for Physician client:\n");
        viewPhysicianAppointments("Dr. Who");

        prescribeMedicine("T. Turner", "Valium", "forty pills", "one pill", "twice per day", 10);

        System.out.println("---------");

        viewPatientFile("T. Turner");

        System.out.println("=======================================================\n");
    }


    private void prescribeMedicine(String patientName, String medicineName, String amount, String dosage, String frequency, int refills) {
        Patient patient = healthCareFacade.findPatient(patientName);
        Medicine medicine = healthCareFacade.findMedicine(medicineName);
        Prescription prescription = new Prescription(medicine, amount, dosage, frequency, refills);
        patient.addPrescription(prescription);
    }

    private void viewPhysicianAppointments(String physName) {
        Physician physician = healthCareFacade.findPhysician(physName);
        System.out.println("Appointments for " + physician.getName());
        for (Appointment appointment : physician.getAppointments()) {
            System.out.println("\t" + appointment.toStringWithoutPhysician());
        }
    }

    private void viewPatientFile(String patientName) {
        Patient patient = healthCareFacade.findPatient(patientName);
        System.out.println("Patient info for " + patientName);
        System.out.println("Appointments: ");
        for (Appointment appointment : patient.getAppointments()) {
            System.out.println("\t" + appointment.toStringWithoutPatient());
        }
        System.out.println("Prescriptions:");
        for (Prescription prescription : patient.getPrescriptions()) {
            System.out.println("\t" + prescription.toString());
        }
    }

}
