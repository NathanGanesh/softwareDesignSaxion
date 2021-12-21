package facade;

import client.OfficeClient;
import client.PharmacyClient;
import client.PhysicianClient;
import client.UnAuthorizedClient;
import database.MedicineDB;
import database.PatientDB;
import database.PhysicianDB;
import database.RoomDB;
import facade.HealthCareFacade;
import model.MedicineType;
import model.Patient;
import model.Physician;
import model.Room;

public class SecSystemSimulation {

    public static void runSimulation(){
        HealthCareFacade facade = new HealthCareFacade();

        OfficeClient office = new OfficeClient(facade);
        office.runSimulation();

        PhysicianClient physicianClient = new PhysicianClient(facade);
        physicianClient.runSimulation();

        PharmacyClient pharmacyClient = new PharmacyClient(facade);
        pharmacyClient.runSimulation();

        UnAuthorizedClient unClient = new UnAuthorizedClient(facade);
        unClient.runSimulation();

        System.out.println("End Secure Facade Simulation");
    }
    public static void bootstrap(){
        HealthCareFacade facade = new HealthCareFacade();
        Room room1 = facade.insertRoom("AD42");
        Room room2 = facade.insertRoom("ES38");
        Room room3 = facade.insertRoom("XP28");

        facade.insertPhysician("Dr. Who", room1);
        facade.insertPhysician("Dr. Eggman", room2);

        facade.insertPatient("T. Turner", 'F', 73);
        facade.insertPatient("D.J. Tiesto", 'M', 45);
        facade.insertPatient("J. Guzman", 'M', 42);

        facade.insertMedicine("Valium", MedicineType.PILL);
        facade.insertMedicine("Cough Syrup", MedicineType.LIQUID);
        facade.insertMedicine("Xanax", MedicineType.PILL);
    }


    public static void main(String[] args) {
        bootstrap();
        runSimulation();
    }

}
