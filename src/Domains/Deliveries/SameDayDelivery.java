package Domains.Deliveries;

import Domains.Couriers;

import java.time.LocalDate;

public class SameDayDelivery extends Delivery{
    public SameDayDelivery(int id,LocalDate expectedDate) {
        super(id, expectedDate);
        expectedDate.minusWeeks(2);
        setShippinfFee(getShippinfFee()+10);
        setCurier(Couriers.DHL);
    }
}
