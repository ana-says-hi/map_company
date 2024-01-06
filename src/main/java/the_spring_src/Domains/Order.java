package the_spring_src.Domains;

import the_spring_src.Domains.Deliveries.BasicDelivery;
import the_spring_src.Domains.Deliveries.Delivery;
import the_spring_src.MementoPattern.OrderMemento;
import the_spring_src.ObserverPattern.Observable;
import the_spring_src.ObserverPattern.Observer;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order implements Observable {
    private ArrayList<Observer> observers= new ArrayList<>();
    int id;
    private Employee employee;
    private Client client;
    private ArrayList<Product> products;
    private float totalPrice;
    private LocalDate date;
    private Status status;
    private Delivery delivery;

    public Order(int id,Client client,Employee employee, LocalDate date) {
        this.id=id;
        this.employee = employee;
        this.client=client;
        this.date = date;
        this.products= new ArrayList<>();
        this.status = Status.PENDING;
        //this.delivery = DeliveryFactory.getInstance().make_deliv(date);
        this.delivery= new BasicDelivery(id, date);
        this.totalPrice=0;
    }

    public Order(int id,Client client,Employee employee,float totalprice,LocalDate date, Status status,Delivery delivery, ArrayList<Product>products) {
        this.id=id;
        this.employee = employee;
        this.client=client;
        this.date = date;
        this.products= products;
        this.status = status;
        this.delivery = delivery;
        this.totalPrice=totalprice;
        for(Product product:products)
        {
            totalPrice+=product.getPrice();
        }
        totalPrice+=delivery.getShippinfFee();
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
        return "ORDER: " + employee.getId()+ "," + client.getId() + "," + productIds + ","+ totalPrice + "," + date + "," + status + ","+ delivery.getExpectedDate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public Status getStatus() {
        return status;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }


    //probabil la controller
//    public void finishOrder(){
//        this.totalPrice+=delivery.getShippinfFee();
//    }

    //memento
    public OrderMemento saveToMemento() {

        return new OrderMemento(status);
    }

    public void restoreFromMemento(OrderMemento memento) {
        this.status = Status.valueOf(memento.getState());
    }


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

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}


