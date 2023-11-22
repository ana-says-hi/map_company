package Tests;

import Domains.Client;
import Domains.Deliveries.BasicDelivery;
import Domains.Deliveries.SameDayDelivery;
import Domains.Employee;
import Domains.Order;

import java.time.LocalDate;

public class TinyTest {
    public void test_delivery() {
        Client client = new Client(1, "Bob", "TheZobStreet 123");
        Employee employee = new Employee(2, "Dob", "1234");
        Order order = new Order(1, client, employee, LocalDate.now());
        assert order.getDelivery().getClass() == BasicDelivery.class;
        assert order.getDate() != order.getDelivery().getExpectedDate();
        order.setDelivery(new SameDayDelivery(order.getId(), order.getDate()));
        assert order.getDelivery().getClass() == SameDayDelivery.class;
        assert order.getDate() == order.getDelivery().getExpectedDate();
    }
}
