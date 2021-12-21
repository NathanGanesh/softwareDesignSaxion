package facade;

import database.MedicineDB;
import database.PatientDB;
import database.PhysicianDB;
import database.RoomDB;
import model.*;

import java.time.LocalDateTime;

public class HealthCareFacade {
    private MedicineDB medicineDB;
    private PatientDB patientDB;
    private PhysicianDB physicianDB;
    private RoomDB roomDB;
    private final String officeToken = "officeToken";
    private final String physToken = "physToken";
    private final String pharmacyToken = "pharmacyToken";
    public HealthCareFacade() {
        this.medicineDB = new MedicineDB();
        this.patientDB = new PatientDB();
        this.physicianDB = new PhysicianDB();
        this.roomDB = new RoomDB();
    }


    public Room findRoom(String roomNr) {
        return roomDB.findRoom(roomNr);
    }

    public Room insertRoom(String numberRoom) {
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

    public void insertMedicine(String name, MedicineType medicineType) {
        medicineDB.insertMedicine(name, medicineType);
    }

    public void createAppointment(String physName, String patName, LocalDateTime appointmentTime, String roomNr, String token) {
        if (!(token.equals(officeToken))) {
            Physician physician = this.findPhysician(physName);
            Patient patient = this.findPatient(patName);
            Room room = null;
            if (roomNr != null) {
                room = this.findRoom(roomNr);
            }
            Appointment appointment = new Appointment(physician, patient, appointmentTime, room);
            patient.addAppointment(appointment);
            physician.addAppointment(appointment);
        }
    }


    public void viewPatientAppointments(String patientName, String token) {
        if (!(token.equals(officeToken))) {
            Patient patient = this.findPatient(patientName);
            System.out.println("Appointments for " + patient.getName());
            for (Appointment appointment : patient.getAppointments()) {
                System.out.println("\t" + appointment.toStringWithoutPatient());
            }
        }
    }
    public StringBuilder fillPrescription(String patientName, String token) {
        if (!(token.equals(pharmacyToken))) {
            Patient patient = this.findPatient(patientName);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Filling prescriptions for " + patientName);
            for (Prescription presp : patient.getPrescriptions()) {
                if (presp.getRemainingRefills() > 0) {
                    presp.decreaseRefills();
                    stringBuilder.append("\t%s - %s (%d refills remaining)\n" + presp.getMedicine() + presp.getAmount() + presp.getRemainingRefills());

                }
            }
            return stringBuilder;
        }
        return null;
    }

    public void prescribeMedicine(String patientName, String medicineName, String amount, String dosage, String frequency, int refills, String token) {
        if (!(token.equals(physToken))) {
            Patient patient = this.findPatient(patientName);
            Medicine medicine = this.findMedicine(medicineName);
            Prescription prescription = new Prescription(medicine, amount, dosage, frequency, refills);
            patient.addPrescription(prescription);
        }

    }

    public StringBuilder viewPhysicianAppointments(String physName, String token) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!(token.equals(physToken))) {
            Physician physician = this.findPhysician(physName);
            stringBuilder.append("Appointments for " + physician.getName());
            for (Appointment appointment : physician.getAppointments()) {
                stringBuilder.append("\t" + appointment.toStringWithoutPhysician());
            }
        }
        return stringBuilder;
    }

    public StringBuilder viewPatientFile(String patientName, String token) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!(token.equals(physToken))) {
            Patient patient = this.findPatient(patientName);
            stringBuilder.append("Patient info for " + patientName);
            stringBuilder.append("Appointments: ");

            for (Appointment appointment : patient.getAppointments()) {
                stringBuilder.append("\t" + appointment.toStringWithoutPatient());
            }
            stringBuilder.append("Prescriptions:");
            for (Prescription prescription : patient.getPrescriptions()) {
                stringBuilder.append("\t" + prescription.toString());
            }
        }
        return stringBuilder;
    }

}
