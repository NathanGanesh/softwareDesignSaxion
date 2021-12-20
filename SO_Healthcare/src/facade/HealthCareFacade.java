package facade;

import client.OfficeClient;
import database.MedicineDB;
import database.PatientDB;
import database.PhysicianDB;
import database.RoomDB;
import model.*;

import java.time.LocalDateTime;
import java.time.Month;

public class HealthCareFacade {
    private MedicineDB medicineDB;
    private PatientDB patientDB;
    private PhysicianDB physicianDB;
    private RoomDB roomDB;

    //
    public HealthCareFacade() {
        this.medicineDB = new MedicineDB();
        this.patientDB = new PatientDB();
        this.physicianDB = new PhysicianDB();
        this.roomDB = new RoomDB();
    }


    public Room findRoom(String roomNr) {
        return roomDB.findRoom(roomNr);
    }

    public Room insertRoom(String numberRoom){
        return roomDB.insertRoom(numberRoom);
    }
//    public Room insertRoom(String numberRoom) {
//        return insertRoom(numberRoom);
//    }

    public Physician insertPhysician(String name, Room defaultRoom) {
        return physicianDB.insertPhysician(name, defaultRoom);
    }

    public Physician findPhysician(String physName) {
        return physicianDB.findPhysician(physName);
    }

    public Patient findPatient(String patName) {
        return patientDB.findPatient(patName);
    }

    public Patient insertPatient(String name, char sex, int age) {
        return patientDB.insertPatient(name, sex, age);
    }

    public Medicine findMedicine(String medicineName) {
        return medicineDB.findMedicine(medicineName);
    }

    public  void insertMedicine(String name, MedicineType medicineType) {
        medicineDB.insertMedicine(name, medicineType);
    }

}
