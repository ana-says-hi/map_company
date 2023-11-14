package Domains;

import Domains.Deliveries.BasicDelivery;
import Domains.Deliveries.Delivery;
import Domains.Deliveries.SameDayDelivery;
import FactoryPattern.DeliveryFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    int id;
    private Employee employee;
    private Client client;
    private ArrayList<Domains.Product> products;
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

    public Order(int id,Client client,Employee employee,ArrayList<Product> products,Delivery delivery,LocalDate date, Status status) {
        this.id=id;
        this.employee = employee;
        this.client=client;
        this.date = date;
        this.products= products;
        this.status = status;
        this.delivery = delivery;
        this.totalPrice=0;
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
        return "ORDER: " + employee.getId()+ "," + client.getId() + "," + productIds + ","+ totalPrice + "," + date + "," + status + ","+ delivery.getId();
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
    public void finishOrder(){
        //se calculeaza iar shipping fee
        this.totalPrice+=delivery.getShippinfFee();
        this.status=Status.CONFIRMED;
    }

}


class TinyTest{
    void test_delivery(){
        Client client=new Client(1,"Bob", "TheZobStreet 123");
        Employee employee=new Employee(2, "Dob", "1234");
        Order order=new Order(1,client,employee,LocalDate.now());
        assert order.getDelivery().getClass() == BasicDelivery.class;
        assert order.getDate()!=order.getDelivery().getExpectedDate();
        order.setDelivery(new SameDayDelivery(order.getId(),order.getDate()));
        assert order.getDelivery().getClass() == SameDayDelivery.class;
        assert order.getDate()==order.getDelivery().getExpectedDate();
    }
}