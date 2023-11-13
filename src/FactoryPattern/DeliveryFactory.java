package FactoryPattern;

import Domains.Couriers;
import Domains.Delivery;
import Domains.Product;
import Domains.ProductType;

import java.time.LocalDate;
import java.util.Date;

public class DeliveryFactory {
    static  DeliveryFactory df_instance;
    private int id=4000;

    private DeliveryFactory(){};

    public static DeliveryFactory getInstance(){
        if(df_instance==null)
            df_instance=new DeliveryFactory();
        return df_instance;
    }

    //basic delivery
    public Delivery make_deliv(LocalDate expectedDate){
        Delivery delivery= new Delivery(id, Couriers.FanCurier, 10,expectedDate);
        id++;
        return delivery;
    }
}
