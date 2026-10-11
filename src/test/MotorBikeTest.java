package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import main.MotorBike;

public class MotorBikeTest {

    @Test
    public void testMotorbike() {

        MotorBike bike =
            new MotorBike(
                "Yamaha",
                "R1",
                2021,
                "HH88 HHH",
                false
            );

        assertEquals("Yamaha", bike.getMake());

        assertEquals("R1", bike.getModel());

        assertEquals(2021, bike.getYear());

        assertEquals("HH88 HHH", bike.getRegNumber());

        assertFalse(bike.isHasSideCar());

        assertEquals(
            300.0,
            bike.calculateCost(2),
            0.01
        );
    }
}