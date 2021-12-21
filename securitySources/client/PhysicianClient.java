package client;

import facade.HealthcareFacade;

public class PhysicianClient {

    private HealthcareFacade facade;
    private String secToken = "physToken";

    public PhysicianClient(HealthcareFacade facade) {
        this.facade =facade;
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
        facade.prescribeMedicine(patientName, medicineName, amount, dosage, frequency, refills, secToken);
    }

    private void viewPhysicianAppointments(String physName) {
        System.out.println("Appointments for " + physName);
        System.out.println(facade.viewPhysicianAppointments(physName, secToken));
    }

    private void viewPatientFile(String patientName) {
        System.out.println("Patient info for " + patientName);
        System.out.println(facade.viewPatientFile(patientName, secToken));
    }

}
