package src.Domains.Deliveries;

import src.Domains.Couriers;

import java.time.LocalDate;

public class FragileStuffDelivery extends Delivery{
    public FragileStuffDelivery(int id, LocalDate expectedDate) {
        super(id, expectedDate);
        curier=Couriers.CARGUS;
    }

    public float getShippinfFee(){
        return super.getShippinfFee()+5;
    }

    public LocalDate getExpectedDate() {
        return super.getExpectedDate().plusWeeks(2);
    }

}
