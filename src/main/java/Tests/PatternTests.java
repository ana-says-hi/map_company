package Tests;
import CommandProcessPattern.OrderProcessor;
import Domains.Order;
import Domains.Status;
import MementoPattern.OrderMemento;
import Reposies.OrderRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class PatternTests {
    // OrderMementoTest
        public void testGetStateWithString() {
            OrderMemento orderMemento = new OrderMemento("Shipped");
            assertEquals("Shipped", orderMemento.getState());
        }
        public void testGetStateWithStatusObject() {
            OrderMemento orderMemento = new OrderMemento(Status.PENDING);
            assertEquals("PENDING", orderMemento.getState());
        }

}
