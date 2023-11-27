package Tests;

import Domains.ContractCourier;
import Domains.Couriers;
//import org.junit.jupiter.api.Test;
import org.junit.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

//import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.Assert.assertEquals;

public class ContractCourierTest {

    @Test
    public void test_calculateSeniority() {
        ContractCourier contractCourier = new ContractCourier(1, "2021-01-01", "2023-01-01", Couriers.DHL, "ABC Company");
        contractCourier.calculateSeniority();
        assertEquals(2, contractCourier.getSeniority());
    }

    @Test
    public void test_updateSeniority() {
        ContractCourier contractCourier = new ContractCourier(1, "2021-01-01", "2023-01-01", Couriers.FedEx, "XYZ Corporation");
        contractCourier.updateSeniority();
        assertEquals(2, contractCourier.getSeniority());
    }
}