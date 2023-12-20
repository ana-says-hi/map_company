package Tests;

import the_spring_src.Domains.ContractEmployee;
import the_spring_src.Domains.EmployeeType;
import org.junit.Test;
//import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContractEmployeeTest {

    @Test
    public void test_calculateSeniority() {
        ContractEmployee contractEmployee = new ContractEmployee(1, "2021-01-01", "2023-01-01", EmployeeType.FULL_TIME);
        contractEmployee.calculateSeniority();
        assertEquals(2, contractEmployee.getSeniority());
    }

    @Test
    public void test_updateSeniority() {
        ContractEmployee contractEmployee = new ContractEmployee(1, "2021-01-01", "2023-01-01", EmployeeType.FULL_TIME);
        contractEmployee.updateSeniority();
        assertEquals(2, contractEmployee.getSeniority());
    }
}