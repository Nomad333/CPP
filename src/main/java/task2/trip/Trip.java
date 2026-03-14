package task2.trip;
import lombok.Data;
import lombok.NonNull;
import task2.driver.Driver;
import task2.vehicle.Vehicle;

@Data
public class Trip {
    private Vehicle vehicle;
    private Driver driver;
    @NonNull
    Double distance;
    @NonNull
    Address address;
    @NonNull
    Integer neededWeight;

    public Integer getNeededExperience() {
        return neededWeight % 5;
    }
}