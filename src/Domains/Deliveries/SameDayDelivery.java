package Domains.Deliveries;

import Domains.Couriers;

import java.time.LocalDate;

public class SameDayDelivery extends Delivery{
    public SameDayDelivery(int id, Couriers curier, float shippinfFee, LocalDate expectedDate) {
        super(id, curier, shippinfFee, expectedDate);
        expectedDate.minusWeeks(2);
        shippinfFee+=10;
        setCurier(Couriers.DHL);
    }
}
