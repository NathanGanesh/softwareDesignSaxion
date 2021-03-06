package client;

import database.PatientDB;
import facade.HealthCareFacade;
import model.Patient;
import model.Prescription;

public class PharmacyClient {
    HealthCareFacade healthCareFacade;
    private String secToken = "pharmacyToken";

    public PharmacyClient(HealthCareFacade facade) {
        this.healthCareFacade = facade;
    }

    public void runSimulation() {

        System.out.println("Simulation for Pharmacy client:\n");
        fillPrescription("T. Turner");
        System.out.println("=======================================================\n");


    }
    private void fillPrescription(String patientName) {
        System.out.println("Filling prescriptions for " + patientName);
        System.out.println(healthCareFacade.fillPrescription(patientName, secToken));
    }
}
