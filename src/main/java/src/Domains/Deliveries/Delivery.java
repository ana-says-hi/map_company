package src.Domains.Deliveries;

import src.Domains.Couriers;

import java.time.LocalDate;

public class Delivery {

    //private Order order;
    protected int id;
    protected Couriers curier;
    protected float shippinfFee=15;
    protected LocalDate expectedDate;

    //ID SI DATEinitial ACELEASI CA LA ORDER
    public Delivery(int id, LocalDate expectedDate) {
        this.id=id;
        //this.curier = curier;
        //this.shippinfFee = shippinfFee;
        this.expectedDate = expectedDate;
    }

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

}