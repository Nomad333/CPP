package task2.vehicle;

public interface Vehicle {
    String getName();
    Integer getMaxWeight();
    VehicleStatus getStatus();
    void setStatus(VehicleStatus status);
}
