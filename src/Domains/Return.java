package Domains;

import java.util.ArrayList;
import java.util.Date;

public class Return extends Order {
    private Date returnDate;
    private float moneyBack;

    public Return(int id, Client client, Employee employee, Date date, Status status, Date returnDate, float moneyBack) {
        super(id, client, employee, date);
        this.returnDate = returnDate;
        this.moneyBack = moneyBack;
    }


    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public float getMoneyBack() {
        return moneyBack;
    }

    public void setMoneyBack(float moneyBack) {
        this.moneyBack = moneyBack;
    }
}
