package Domains;

import ObserverPattern.Observable;
import ObserverPattern.Observer;

import java.util.ArrayList;

public class Product implements Observable {
    private int id;
    private String name;
    private float price;
    private ProductType type;
    private int stoc;

    private ArrayList<Observer> observers= new ArrayList<>();


    //produsele au cifra de inceput 3 +numarul de 4
    //clientii au cifra de inceput 2 +numarul de 4
    // angajatii au cifra de inceput 1+numarul de 4
    //si pt orders??
    //BAGAM DESCRIERE DE PRODUSE
    //TODO OBSERVER PT STOC SI PRET
    //reduceri??

    public Product(int id, String name, float price, ProductType type, int stoc) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.stoc=stoc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public void add_stoc(int added){
        stoc+=added;
    }
    public void sub_stoc(int minus){
        stoc-=minus;
        if(stoc<50)
            notifyObservers();
    }

    @Override
    public String toString() {
        return "PRODUCT: " + id + ',' + name + ',' + price + ',' + type + ',' + stoc;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public boolean removeObserver(Observer observer) {
        if(observers.contains(observer)) {
            observers.remove(observer);
            return true;
        }
        return false;
    }

    @Override
    public void notifyObservers() {
        for(Observer observer: observers)
            observer.update(this);
    }

}