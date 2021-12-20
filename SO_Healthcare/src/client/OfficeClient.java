package client;

import database.PatientDB;
import database.PhysicianDB;
import database.RoomDB;
import facade.HealthCareFacade;
import model.Appointment;
import model.Patient;
import model.Physician;
import model.Room;

import java.time.LocalDateTime;
import java.time.Month;

public class OfficeClient {
    HealthCareFacade healthCareFacade;

    public OfficeClient(HealthCareFacade healthCareFacade) {
        this.healthCareFacade = healthCareFacade;
    }

    public void runSimulation() {
        System.out.println("Simulation for Office client:\n");
        createAppointment("Dr. Who", "T. Turner", LocalDateTime.of(2021, Month.AUGUST, 22, 15, 45, 00), null); // appointment on 22 Aug 2021 at 15:45
        createAppointment("Dr. Who", "D.J. Tiesto", LocalDateTime.of(2021, Month.AUGUST, 22, 16, 15, 00), "XP28");
        createAppointment("Dr. Who", "D.J. Tiesto", LocalDateTime.of(2021, Month.AUGUST, 31, 16, 00, 00), null);
        viewPhysicianAppointments("Dr. Who");

        System.out.println();

        createAppointment("Dr. Eggman", "J. Guzman", LocalDateTime.of(2021, Month.JULY, 02, 10, 00, 00), null);
        createAppointment("Dr. Eggman", "T. Turner", LocalDateTime.of(2021, Month.SEPTEMBER, 19, 11, 30, 00), null);
        viewPhysicianAppointments("Dr. Eggman");

        System.out.println();

        viewPatientAppointments("T. Turner");
        System.out.println("=======================================================\n");
    }




    private void createAppointment(String physName, String patName, LocalDateTime appointmentTime, String roomNr) {
        Physician physician = healthCareFacade.findPhysician(physName);
        Patient patient = healthCareFacade.findPatient(patName);
        Room room = null;
        if(roomNr != null){
            room = healthCareFacade.findRoom(roomNr);
        }
        Appointment appointment = new Appointment(physician, patient, appointmentTime, room);
        patient.addAppointment(appointment);
        physician.addAppointment(appointment);
    }

    private void viewPhysicianAppointments(String physName) {
        Physician physician = healthCareFacade.findPhysician(physName);
        System.out.println("Appointments for " + physician.getName());
        for(Appointment appointment: physician.getAppointments()){
            System.out.println("\t" + appointment.toStringWithoutPhysician());
        }
    }

    private void viewPatientAppointments(String patientName) {
        Patient patient = healthCareFacade.findPatient(patientName);
        System.out.println("Appointments for " + patient.getName());
        for(Appointment appointment: patient.getAppointments()){
            System.out.println("\t" + appointment.toStringWithoutPatient());
        }
    }

}
