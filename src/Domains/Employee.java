package Domains;

public class Employee {

    //propuneri
    //change status la o livrare
    //ANGAJATUL SA FIE ENUM, CURIERUL SCHIMBA STATUS COMANDA

    private int id;
    private String name;
    private String password;

    public Employee(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
