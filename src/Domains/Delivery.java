package Domains;

import java.util.Date;

public class Delivery {

    //private Order order;
    private int id;
    private Couriers curier;
    private float shippinfFee;
    private Date expectedDate;

    public Delivery(int id, Couriers curier, float shippinfFee, Date expectedDate) {
        this.id=id;
        this.curier = curier;
        this.shippinfFee = shippinfFee;
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

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + "\t" + curier + "\t" + shippinfFee + "\t" + expectedDate;
    }
}
