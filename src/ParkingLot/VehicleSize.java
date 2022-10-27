package ParkingLot;

public enum VehicleSize {
    Compact (0),
    Regular (1),
    Large (2);

    private final int size;

    VehicleSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return this.size;
    }
}