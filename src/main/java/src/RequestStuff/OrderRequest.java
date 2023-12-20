package src.RequestStuff;

import src.Domains.Client;
import src.Domains.Deliveries.Delivery;
import src.Domains.Employee;
import src.Domains.Product;
import src.Domains.Status;

import java.time.LocalDate;
import java.util.ArrayList;

public class OrderRequest {
    private Employee employee;
    private Client client;
    private ArrayList<Product> products;
    private float totalPrice;
    private LocalDate date;
    private Status status;
    private Delivery delivery;

    public Employee getEmployee() {
        return employee;
    }

    public Client getClient() {
        return client;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public LocalDate getDate() {
        return date;
    }

    public Status getStatus() {
        return status;
    }

    public Delivery getDelivery() {
        return delivery;
    }
}
