package Domains;

import ObserverPattern.Observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

public class Order {
    int id;
    private Employee employee;
    private Client client;
    private ArrayList<Domains.Product> products;
    private float totalPrice=0;
    private Date date;
    private Status status=Status.PENDING;
    private Delivery delivery;

    public Order(int id,Client client,Employee employee, Date date) {
        this.id=id;
        this.employee = employee;
        this.client=client;
        this.date = date;
        //TODO initializat un delivery aici
        //this.delivery = delivery;
        //TODO TOTAL PRICE= PRODUSE+TAXA TRANSPORT
    }

    public void addProduct(Product prod1){
        products.add(prod1);
        totalPrice+= prod1.getPrice();
    }
    public void deleteProduct(Product prod1){
        if(products.contains(prod1)) {
            products.remove(prod1);
            totalPrice-= prod1.getPrice();
        }
    }

    //change order
    //TODO validdare produse pe stoc

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    @Override
    public String toString() {
        String productIds = "";
        if (products != null && !products.isEmpty()) {
            for (int i = 0; i < products.size(); i++) {
                productIds += products.get(i).getId();
                if (i < products.size() - 1) {
                    productIds += "&";
                }
            }
        }
        return "ORDER: " + employee.getId()+ "," + client.getId() + "," + productIds + ","+ totalPrice + "," + date + "," + status + ","+ delivery.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}