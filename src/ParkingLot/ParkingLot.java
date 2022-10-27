package ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private Level[] levels;

    public ParkingLot(int numOfLevels, int numSpotsPerLevel) {
        this.levels = new Level[numOfLevels];

        for (int i = 0; i < numOfLevels; i++) {
            this.levels[i] = new Level(numSpotsPerLevel);
        }
    }

    public boolean hasSpot(Vehicle v) {
        // check each level, for each level, call Level.hasSpot(Vehicle)
        for (Level curLevel: levels) {
            if (curLevel.hasSpot(v)) {
                return true;
            }
        }

        return false;
    }

    public boolean park(Vehicle v) {
        for (Level curLevel: this.levels) {
            if (curLevel.park(v)) {
                return true;
            }
        }

        return false;
    }

    public boolean leave(Vehicle v) {
        for (Level curLevel: this.levels) {
            if (curLevel.leave(v)) {
                return true;
            }
        }

        return false;
    }
}

class Level{
    private ParkingSpot[] parkingSpots;

    Level(int numOfSpots) {
        this.parkingSpots = new ParkingSpot[numOfSpots];

        int index = 0;

        // The level has half Large spots and half compact spots by default
        for (; index < numOfSpots / 2; index++) {
            this.parkingSpots[index] = new ParkingSpot(VehicleSize.Compact);
        }

        for (; index < numOfSpots; index++) {
            this.parkingSpots[index] = new ParkingSpot(VehicleSize.Large);
        }
    }

    boolean hasSpot(Vehicle v) {
        for (ParkingSpot ps: this.parkingSpots) {
            if (ps.fit(v)) {
                return true;
            }
        }

        return false;
    }

    boolean park(Vehicle v) {
        for (ParkingSpot ps: this.parkingSpots) {
            if (ps.fit(v)) {
                ps.park(v);
                return true;
            }
        }

        return false;
    }

    boolean leave(Vehicle v) {
        for (ParkingSpot s: this.parkingSpots) {
            if (s.getCurrentVehicle() == v) {
                s.leave();
                return true;
            }
        }

        return false;
    }
}

class ParkingSpot{
    // TODO: check size and availability
    private final VehicleSize size;
    private Vehicle currentVehicle; // null if no vehicle is parked inside

    ParkingSpot(VehicleSize size) {
        this.size = size;
    }

    boolean isAvailable() {
        return this.currentVehicle == null;
    }

    boolean fit(Vehicle v) {
        if (!this.isAvailable()) {
            return false;
        }

        return this.getSize().getSize() >= v.getSize().getSize();
    }

    boolean park(Vehicle v) {
        if (!this.fit(v)) {
            return false;
        }

        setCurrentVehicle(v);
        return true;
    }

    Vehicle leave() {
        Vehicle temp = this.getCurrentVehicle();
        this.currentVehicle = null;

        return temp;
    }

    Vehicle getCurrentVehicle() {
        return this.currentVehicle;
    }

    void setCurrentVehicle(Vehicle v) {
        this.currentVehicle = v;
    }

    VehicleSize getSize() {
        return this.size;
    }
}

class Test {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(4, 10);
        List<Vehicle> list = new ArrayList<>();
        System.out.println("Tests start");

        for (int i = 0; i < 50; i++) {
            final Vehicle v = i % 2 == 0 ? new Car("") : new Truck("");
            list.add(v);
            boolean hasSpot = lot.hasSpot(v);

            if (i < 40) {
                assert hasSpot;
                assert lot.park(v);
            }
            else {
                assert !hasSpot : "should not have spot";
                assert !lot.park(v);
            }
        }

        assert list.size() == 50;

        int i = 0;
        for (Vehicle v: list) {
            assert i >= 40 || lot.leave(v);
            i++;
        }

        System.out.println("Tests end");
    }
}
