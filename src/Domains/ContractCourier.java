package Domains;

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
        // Implementare specifică pentru calculul vechimii pentru curieri
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
