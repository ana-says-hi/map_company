package Tests;
import src.Domains.Status;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class PatternTests {
    private Status Status;

    // OrderMementoTest
        public void testGetStateWithString() {
            OrderMemento orderMemento = new OrderMemento("Shipped");
            assertEquals("Shipped", orderMemento.getState());
        }
        public void testGetStateWithStatusObject() {
            OrderMemento orderMemento = new OrderMemento(Status.PENDING.toString());
            assertEquals("PENDING", orderMemento.getState());
        }

    private class OrderMemento {
        public OrderMemento(String shipped) {

        }

        public String getState() {
            return null;
        }
    }
}
