package the_spring_src.Domains;

import the_spring_src.ObserverPattern.Observer;

public class Client implements Observer <Order>{
    int id;
    String name;
    String address;

    public Client(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
    //Domains.Order order;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    @Override
    public String toString() {
        return "CLIENT: " + id + ',' + name + ','+ address;
    }

    @Override
    public void update(Order order) {
        if(order.getClient()==this)
            System.out.println("Comanda este: "+order.getStatus());
        else System.out.println("Comanda nu va apartine");
    }

}