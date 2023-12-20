package the_spring_src.Domains.Deliveries;

import the_spring_src.Domains.Couriers;

import java.time.LocalDate;
import java.util.Random;

public class SuperSafeDelivery extends Delivery{
    private String tracking_code;
    public SuperSafeDelivery(int id, LocalDate expectedDate) {
        super(id, expectedDate);
        tracking_code=generate_tracking_code(6);
        curier=Couriers.FedEx;
    }

    public String getTracking_code() {
        return tracking_code;
    }

    public float getShippinfFee(){
        return super.getShippinfFee()+15;
    }

    public LocalDate getExpectedDate() {
        return super.getExpectedDate().plusWeeks(2);
    }

    private static String generate_tracking_code(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();
//ca sa verificam partea cu codul de 6 chestii o sa verificam daca comanda de safety are un cod de lg 6
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }

        return randomString.toString();
    }
}
