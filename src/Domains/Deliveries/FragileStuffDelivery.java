package Domains.Deliveries;

import Domains.Couriers;

import java.time.LocalDate;

public class FragileStuffDelivery extends Delivery{
    public FragileStuffDelivery(int id, LocalDate expectedDate) {
        super(id, expectedDate);
        shippinfFee+=5;
        expectedDate=expectedDate.plusWeeks(2);
        curier=Couriers.CARGUS;
    }
}
