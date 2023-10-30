package Domains;

public class Client {
    int id;
    String name;
    String adress;

    public Client(int id, String name, String adress) {
        this.id = id;
        this.name = name;
        this.adress = adress;
    }
    //Domains.Order order;

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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
        return id + ',' + name + ','+ adress;
    }

}
