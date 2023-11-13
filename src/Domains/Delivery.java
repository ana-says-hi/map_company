package Domains;

import java.time.LocalDate;
import java.util.Date;

public class Delivery {

    //private Order order;
    private int id;
    private Couriers curier;
    private float shippinfFee;
    private LocalDate expectedDate;

    public Delivery(int id, Couriers curier, float shippinfFee, LocalDate expectedDate) {
        this.id=id;
        this.curier = curier;
        this.shippinfFee = shippinfFee;
        this.expectedDate = expectedDate;
    }

//    public Delivery same_day_deliv(){
//        curier=Couriers.DHL;
//        shippinfFee+=4;
//        expectedDate=expectedDate.minusWeeks(2);
//    return this;
//    }

    public Couriers getCurier() {
        return curier;
    }

    public void setCurier(Couriers curier) {
        this.curier = curier;
    }

    public float getShippinfFee() {
        return shippinfFee;
    }

    public void setShippinfFee(float shippinfFee) {
        this.shippinfFee = shippinfFee;
    }

    public LocalDate getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(LocalDate expectedDate) {
        this.expectedDate = expectedDate;
    }

    @Override
    public String toString() {
        return id + "\t" + curier + "\t" + shippinfFee + "\t" + expectedDate;
    }

    public int getId() {
        return id;
    }
}
