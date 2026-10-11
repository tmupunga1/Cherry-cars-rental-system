package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import main.CherryCars;
import main.Customer;
import main.ElectricCar;
import main.NonElectricCar;
import main.Vehicle;

public class CherryCarsTest {

    private CherryCars company;

    private Vehicle v1;
    private Vehicle v2;

    private Customer customer;

    @Before
    public void setUp() {

        company = new CherryCars();

        v1 = new ElectricCar(
            "Tesla",
            "Model 3",
            2022,
            "AA11 AAA",
            4,
            320
        );

        v2 = new NonElectricCar(
            "Ford",
            "Focus",
            2019,
            "DD44 DDD",
            4,
            "Petrol"
        );

        customer = new Customer("123ABC");
    }

    @Test
    public void testGetAvailableByMake() {

        company.addVehicle(v1);
        company.addVehicle(v2);

        assertEquals(
            1,
            company.getAvailableByMake("Tesla").size()
        );

        assertEquals(
            1,
            company.getAvailableByMake("Ford").size()
        );

        assertEquals(
            0,
            company.getAvailableByMake("BMW").size()
        );
    }

    @Test
    public void testReturnVehicle() {

        customer.rentVehicle(v1);

        assertFalse(v1.isAvailable());

        assertTrue(customer.returnVehicle(v1));

        assertTrue(v1.isAvailable());

        assertEquals(
            0,
            customer.getCurrentRentals().size()
        );

        assertEquals(
            1,
            customer.getPreviousRentals().size()
        );
    }
}