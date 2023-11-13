package Domains.Deliveries;

import Domains.Couriers;

import java.time.LocalDate;

public class BasicDelivery extends Delivery{
    public BasicDelivery(int id, LocalDate expectedDate) {
        super(id, expectedDate);
        expectedDate=expectedDate.plusWeeks(2);
        curier=Couriers.FanCurier;
    }
}
