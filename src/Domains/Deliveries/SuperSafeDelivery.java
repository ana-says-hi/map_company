package Domains.Deliveries;

import Domains.Couriers;

import java.time.LocalDate;
import java.util.Random;

public class SuperSafeDelivery extends Delivery{
    private String tracking_code;
    public SuperSafeDelivery(int id, Couriers curier, float shippinfFee, LocalDate expectedDate) {
        super(id, curier, shippinfFee, expectedDate);
        tracking_code=generate_tracking_code(6);
        setCurier(Couriers.FedEx);
        shippinfFee+=15;
        expectedDate=expectedDate.plusWeeks(2);
    }

    public String getTracking_code() {
        return tracking_code;
    }

    private static String generate_tracking_code(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }

        return randomString.toString();
    }
}
