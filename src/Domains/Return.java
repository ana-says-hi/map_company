package Domains;

import java.util.ArrayList;
import java.util.Date;

public class Return extends Order {
    private Date returnDate;
    private float moneyBack;
    public Return(Employee employee, ArrayList<Product> products, Date date, Status status) {
        //retr date= date+ o luna idk
        //money back= idk
        super(employee, products, date, status);
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
