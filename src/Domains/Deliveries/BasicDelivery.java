package Domains.Deliveries;

import Domains.Couriers;

import java.time.LocalDate;

public class BasicDelivery extends Delivery{
    public BasicDelivery(int id, Couriers curier, float shippinfFee, LocalDate expectedDate) {
        super(id, curier, shippinfFee, expectedDate);
        setCurier(Couriers.FanCurier);
        expectedDate=expectedDate.plusWeeks(2);
    }
}
