package task2.vehicle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DefaultVehicleTest {
    Vehicle vehicleNoArgs;

    @BeforeEach
    void setUp() {
        vehicleNoArgs = new DefaultVehicle();
    }

    @Test
    void testVehicleStatus() {
        assertEquals(VehicleStatus.OK, vehicleNoArgs.getStatus());

        vehicleNoArgs.setStatus(VehicleStatus.BROKEN);
        assertEquals(VehicleStatus.BROKEN, vehicleNoArgs.getStatus());
    }

    @Test
    void testVehicleParamsNotNull() {
        assertNotNull(vehicleNoArgs.getName());
        assertNotNull(vehicleNoArgs.getStatus());
        assertNotNull(vehicleNoArgs.getMaxWeight());
    }
}
