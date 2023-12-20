package the_spring_src.Domains;

import java.time.LocalDate;

public class Return extends Order {
    private LocalDate returnDate;
    private float moneyBack;

    public Return(int id, Client client, Employee employee, LocalDate date, Status status, LocalDate returnDate, float moneyBack) {
        super(id, client, employee, date);
        this.returnDate = returnDate;
        this.moneyBack = moneyBack;
    }


    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public float getMoneyBack() {
        return moneyBack;
    }

    public void setMoneyBack(float moneyBack) {
        this.moneyBack = moneyBack;
    }
}
