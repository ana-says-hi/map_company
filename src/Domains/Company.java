package Domains;

import java.util.ArrayList;

import Controll.ProductController;
import ObserverPattern.Observer;
import Reposies.ProductRepo;

public class Company implements Observer<Product> {
    String name;
    ArrayList<Employee> employees;
    String about_us;
    //ArrayList<Product> products;

    public Company(String name, ArrayList<Employee> employees, String about_us) {
        this.name = name;
        this.employees = employees;
        this.about_us = about_us;
//        ProductRepo productRepo=new ProductRepo();
//        this.products=productRepo.getP_repo();
        //this.products=ProductController.getInstance().getStuff();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public String getAbout_us() {
        return about_us;
    }

    @Override
    public void update(Product product) {
        System.out.println("MAI CUMPARA CHESTII FRA");
        //TODO contrsct curier sau ce era cu order niu ig
    }
}
