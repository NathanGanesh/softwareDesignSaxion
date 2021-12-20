package database;

import model.Physician;
import model.Room;

import java.util.HashMap;
import java.util.Map;

public class PhysicianDB {

    private static Map<String, Physician> physicians = new HashMap<>();

    public Physician insertPhysician(String name, Room defaultRoom) {
        Physician phys = new Physician(name, defaultRoom);
        physicians.put(name, phys);
        return phys;
    }

    public Physician findPhysician(String physName) {
        return physicians.get(physName);
    }
}
