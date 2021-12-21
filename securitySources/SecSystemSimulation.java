import client.OfficeClient;
import client.PharmacyClient;
import client.PhysicianClient;
import client.UnAuthorizedClient;
import database.MedicineDB;
import database.PatientDB;
import database.PhysicianDB;
import database.RoomDB;
import facade.HealthcareFacade;
import model.MedicineType;
import model.Patient;
import model.Physician;
import model.Room;

public class SecSystemSimulation {

    public static void runSimulation(){
        HealthcareFacade facade = new HealthcareFacade();

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


    public static void main(String[] args) {
        runSimulation();
    }

}
