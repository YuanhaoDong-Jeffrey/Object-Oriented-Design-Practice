package FactoryPattern.RoomFactory;

public class Room {
    private Room nextRoom;

    public void connect(Room otherRoom) {
        this.nextRoom = otherRoom;
        otherRoom.nextRoom = this;
    }
}

class OrdinaryRoom extends Room {
    public OrdinaryRoom(String name, int size) {
        System.out.println("Ordinary: " + name + String.valueOf(size));
    }
}

class MagicRoom extends Room {
    public MagicRoom(String name, String magic, int size) {
        System.out.println("Magic: " + name + magic + String.valueOf(size));
    }
}
