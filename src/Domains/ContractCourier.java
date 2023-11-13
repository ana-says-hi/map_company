package Domains;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class ContractCourier extends Partnership {

    private Couriers courier;
    private String companyName; // Numele firmei

    public ContractCourier(int id, String startDate, String endDate, Couriers courier, String companyName) {
        super(id, startDate, endDate);
        this.courier = courier;
        this.companyName = companyName;
    }

    @Override
    public void calculateSeniority() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date currentDate = new Date();
            Date startDate = sdf.parse(this.startDate);

            LocalDate localCurrentDate = LocalDate.ofInstant(currentDate.toInstant(), ZoneId.systemDefault());
            LocalDate localStartDate = LocalDate.ofInstant(startDate.toInstant(), ZoneId.systemDefault());

            // Calculăm diferența de ani între data curentă și data de început a contractului
            long diffInYears = ChronoUnit.YEARS.between(localStartDate, localCurrentDate);
            this.seniority = (int) diffInYears;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateSeniority() {
        calculateSeniority();
    }

    @Override
    public void displayDetails() {
        System.out.println("Courier Contract Details:");
        System.out.println("ID: " + id);
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
        System.out.println("Seniority: " + getSeniority());
        System.out.println("Courier: " + courier);
        System.out.println("Company Name: " + companyName);
        System.out.println("Contract History: " + getContractHistory());
    }
}
