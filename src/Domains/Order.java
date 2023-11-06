package Domains;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    int id;
    private Employee employee;
    private Client client;
    private ArrayList<Domains.Product> products;
    private float totalPrice;
    private String date;
    private Status status;
    private Delivery delivery;

    public Order(int id,Client client,Employee employee, String date, Status status) {
        this.id=id;
        this.employee = employee;
        this.client=client;
        //this.products = products; TODO LE IA DIN REPO
        this.date = date;
        this.status = status;
        //TODO initializat un delivery aici
        //this.delivery = delivery;
        //TODO TOTAL PRICE= PRODUSE+TAXA TRANSPORT
    }

    public void addProduct(Product prod1){
        products.add(prod1);
    }

    //TODO ADD PRODUCT+ TOTAL PRICE
    //change order
    //validdare produse pe stoc

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

//    public void setProducts(ArrayList<Product> products) {
//        this.products = products;
//    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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