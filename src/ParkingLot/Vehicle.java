package ParkingLot;

public abstract class Vehicle {
    private final String plate;

    protected Vehicle(String plate) {
        this.plate = plate;
    }

    public abstract VehicleSize getSize();
}

class Car extends Vehicle{
    protected Car(String plate) {
        super(plate);
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.Compact;
    }
}

class SUV extends Vehicle{
    protected SUV(String plate) {
        super(plate);
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.Regular;
    }
}

class Truck extends Vehicle{
    protected Truck(String plate) {
        super(plate);
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.Large;
    }


}