package Domains;

import java.util.ArrayList;

import Reposies.ProductRepo;

public class Company {
    String name;
    ArrayList<Employee> employees;
    String about_us;
    ArrayList<Product> products;

    public Company(String name, ArrayList<Employee> employees, String about_us) {
        this.name = name;
        this.employees = employees;
        this.about_us = about_us;
        ProductRepo productRepo=new ProductRepo();
        this.products=productRepo.getP_repo();
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
}
