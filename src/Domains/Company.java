package Domains;

import java.util.ArrayList;

public class Company {
    String name;
    ArrayList<Employee> employees;
    String about_us;

    public Company(String name, ArrayList<Employee> employees, String about_us) {
        this.name = name;
        this.employees = employees;
        this.about_us = about_us;
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
