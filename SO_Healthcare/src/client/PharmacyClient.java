package client;

import database.PatientDB;
import facade.HealthCareFacade;
import model.Patient;
import model.Prescription;

public class PharmacyClient {
    HealthCareFacade healthCareFacade;

    public PharmacyClient(HealthCareFacade facade) {
        this.healthCareFacade = facade;
    }

    public void runSimulation() {

        System.out.println("Simulation for Pharmacy client:\n");
        fillPrescription("T. Turner");
        System.out.println("=======================================================\n");


    }

    private void fillPrescription(String patientName) {
        Patient patient = healthCareFacade.findPatient(patientName);
        System.out.println("Filling prescriptions for " + patientName);
        for (Prescription presp : patient.getPrescriptions()) {
            if (presp.getRemainingRefills() > 0) {
                presp.decreaseRefills();
                System.out.printf("\t%s - %s (%d refills remaining)\n", presp.getMedicine(), presp.getAmount(), presp.getRemainingRefills());
            }
        }
    }
}
