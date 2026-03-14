package task2.driver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DriverTest {
    private Driver driver;

    @BeforeEach
    void setUp() {
        driver = new Driver("foo", "bar", "123",1);
        driver= new Driver("foo", "bar", "123", 1);
    }

    @Test
    void testDriverParamsNotNull() {
        assertNotNull(driver.getName());
        assertNotNull(driver.getSurname());
        assertNotNull(driver.getPhone());
    }

    @Test
    void testDriverEquals() {
        Driver driver2 = new Driver("foo", "bar", "123", 1);
        assertEquals(driver, driver2);
    }

    @Test
    void testDriverNotEquals() {
        Driver driver2 = new Driver("foo", "bar", "1234", 1);
        assertNotEquals(driver, driver2);
    }
}
