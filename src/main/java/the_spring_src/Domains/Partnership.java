package the_spring_src.Domains;

import java.util.ArrayList;
import java.util.List;

public abstract class Partnership {

    protected int id;
    protected String startDate;
    protected String endDate;
    protected boolean isContractActive;
    protected int seniority;
    protected List<Partnership> contractHistory;
    protected Couriers courier; // Adăugarea referinței către Couriers

    public Partnership(int id, String startDate, String endDate, Couriers courier) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isContractActive = true;
        this.seniority = 0;
        this.contractHistory = new ArrayList<>();
        this.courier = courier;
    }

    public Partnership(int id, String startDate, String endDate) {
    }

    public boolean isContractActive() {
        return isContractActive;
    }

    public void finalizeContract() {
        isContractActive = false;
        updateSeniority();
        contractHistory.add(this); // Adaugă contractul în istoric
    }

    public int getSeniority() {
        return seniority;
    }

    public List<Partnership> getContractHistory() {
        return new ArrayList<>(contractHistory);
    }

    public abstract void calculateSeniority();

    public abstract void updateSeniority();

    public abstract void displayDetails();
}
