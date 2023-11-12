package Domains;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

            // Transformăm datele în string-uri pentru a le putea compara
            String strCurrentDate = sdf.format(currentDate);
            String strStartDate = sdf.format(startDate);

            // Calculăm diferența de ani între data curentă și data de început a contractului
            int diffInYears = calculateDiffInYears(strStartDate, strCurrentDate);

            this.seniority = diffInYears;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    // Funcție pentru calcularea diferenței de ani între două date sub formă de string-uri "yyyy-MM-dd"
    private int calculateDiffInYears(String startDate, String endDate) {
        int startYear = Integer.parseInt(startDate.substring(0, 4));
        int endYear = Integer.parseInt(endDate.substring(0, 4));

        return endYear - startYear;
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