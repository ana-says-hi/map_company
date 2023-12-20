package Tests;

import src.Domains.ContractCourier;
import src.Domains.Couriers;
import org.junit.Test;

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