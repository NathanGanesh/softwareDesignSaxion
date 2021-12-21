package client;

import database.PatientDB;
import facade.HealthcareFacade;
import model.Patient;
import model.Prescription;

public class PharmacyClient {

    private HealthcareFacade facade;
    private String secToken = "pharmacyToken";

    public PharmacyClient(HealthcareFacade facade) {
        this.facade = facade;
    }

    public void runSimulation(){

        System.out.println("Simulation for Pharmacy client:\n");
        fillPrescription("T. Turner");
        System.out.println("=======================================================\n");


    }

    private void fillPrescription(String patientName) {
        System.out.println("Filling prescriptions for " + patientName);
        System.out.println(facade.fillPrescription(patientName, secToken));
    }
}
