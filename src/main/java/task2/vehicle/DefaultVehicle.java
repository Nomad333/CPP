package task2.vehicle;

import lombok.*;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class DefaultVehicle implements Vehicle  {
    private String name = "";
    private Integer maxWeight = 0;
    private VehicleStatus status = VehicleStatus.OK;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getMaxWeight() {
        return maxWeight;
    }

    @Override
    public VehicleStatus getStatus() {
        return status;
    }

    @Override
    public void setStatus(VehicleStatus status) {
        this.status = status;
    }
}
