package client;

import facade.HealthCareFacade;

public class UnAuthorizedClient {

    private HealthCareFacade facade;
    private String secToken = "pharmacyToken"; // client has a pharmacyToken

    public UnAuthorizedClient(HealthCareFacade facade) {
        this.facade = facade;
    }

    public void runSimulation(){

        System.out.println("Simulation for Unauthorized Pharmacy client:\n");
        fillPrescription("T. Turner"); // ok
        viewPatientFile("T. Turner");

        System.out.println("=======================================================\n");


    }

    private void viewPatientFile(String name) {
        System.out.println(facade.viewPatientFile("T. Turner", secToken));
    }

    private void fillPrescription(String patientName) {
        System.out.println("Filling prescriptions for " + patientName);
        System.out.println(facade.fillPrescription(patientName, secToken));
    }
}

