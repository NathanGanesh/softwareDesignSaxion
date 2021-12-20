package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Appointment {

    private LocalDateTime time;
    private Patient patient;
    private Physician physician;
    private Room room;

    public Appointment(Physician physician, Patient patient, LocalDateTime appointmentTime, Room room) {
        this.physician = physician;
        this.patient = patient;
        this.time = appointmentTime;
        if (room == null) {
            this.room = physician.getRoom();
        } else {
            this.room = room;
        }
    }

    public String toStringWithoutPhysician() {
        return String.format("%s\t%-15s room: %s",
                time.format(DateTimeFormatter.ofPattern("dd MMM yyyy - HH:mm")),
                patient.toString(), room.getNumber());
    }

    public String toStringWithoutPatient() {
        return String.format("%s\t%-15s room: %s",
                time.format(DateTimeFormatter.ofPattern("dd MMM yyyy - HH:mm")),
                physician.toString(), room.getNumber());
    }
}
