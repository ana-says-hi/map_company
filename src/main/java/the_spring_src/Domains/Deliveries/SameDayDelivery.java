package the_spring_src.Domains.Deliveries;

import the_spring_src.Domains.Couriers;

import java.time.LocalDate;

public class SameDayDelivery extends Delivery{
    public SameDayDelivery(int id,LocalDate expectedDate) {
        super(id, expectedDate);
        setCurier(Couriers.DHL);
    }

    public float getShippinfFee(){
        return super.getShippinfFee()+10;
    }

    public LocalDate getExpectedDate() {
        return super.getExpectedDate();
    }
}
