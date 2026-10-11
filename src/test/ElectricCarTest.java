package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.ElectricCar;

public class ElectricCarTest {

    @Test
    public void testElectricCar() {

        ElectricCar car =
            new ElectricCar(
                "Tesla",
                "Model 3",
                2022,
                "AA11 AAA",
                4,
                320
            );

        assertEquals("Tesla", car.getMake());

        assertEquals("Model 3", car.getModel());

        assertEquals(2022, car.getYear());

        assertEquals("AA11 AAA", car.getRegNumber());

        assertEquals(4, car.getNumDoors());

        assertEquals(320, car.getMilesPerCharge());

        assertEquals(
            360.0,
            car.calculateCost(3),
            0.01
        );
    }
}