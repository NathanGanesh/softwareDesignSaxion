package model;

import java.util.ArrayList;
import java.util.List;

public class Physician {
    private String name;
    private Room defaultRoom;
    private List<Appointment> appointments = new ArrayList<>();

    public Physician(String name, Room defaultRoom) {
        this.name = name;
        this.defaultRoom = defaultRoom;
    }

    public Room getRoom() {
        return defaultRoom;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public Appointment[] getAppointments() {
        return appointments.toArray(new Appointment[0]);
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return name;
    }
}
