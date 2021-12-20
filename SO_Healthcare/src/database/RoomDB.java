package database;

import model.Room;
import java.util.HashMap;
import java.util.Map;

public class RoomDB {
    private static Map<String, Room> rooms = new HashMap<String, Room>();

    public Room insertRoom(String number) {
        Room room = new Room(number);
        rooms.put(number, room);
        return room;
    }

    public   Room findRoom(String roomNr) {
        return rooms.get(roomNr);
    }
}
