package client;

import facade.HealthcareFacade;

public class UnAuthorizedClient {

    private HealthcareFacade facade;
    private String secToken = "pharmacyToken"; // client has a pharmacyToken

    public UnAuthorizedClient(HealthcareFacade facade) {
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

