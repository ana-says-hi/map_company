package the_spring_src.Domains.Deliveries;

import the_spring_src.Domains.Couriers;

import java.time.LocalDate;

public class BasicDelivery extends Delivery{
    public BasicDelivery(int id, LocalDate expectedDate) {
        super(id, expectedDate);
        curier=Couriers.FanCurier;
    }

    public LocalDate getExpectedDate() {
        return super.getExpectedDate().plusWeeks(2);
    }
}
