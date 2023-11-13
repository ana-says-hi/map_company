package Domains.Deliveries;

import Domains.Couriers;

import java.time.LocalDate;

public class FragileStuffDelivery extends Delivery{
    public FragileStuffDelivery(int id, Couriers curier, float shippinfFee, LocalDate expectedDate) {
        super(id, curier, shippinfFee, expectedDate);
        shippinfFee+=5;
        setCurier(Couriers.CARGUS);
        expectedDate=expectedDate.plusWeeks(2);
    }
}
