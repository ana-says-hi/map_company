package src.Domains;

import java.sql.SQLException;
import java.util.ArrayList;

import src.Controll.EmployeeController;
import src.Controll.ProductController;
import src.ObserverPattern.Observer;

public class Company implements Observer<Product> {
    String name;
    ArrayList<Employee> employees;
    String about_us;
    ArrayList<Product> products;
    private static Company cmp_instance;

/*    public Company(String name, ArrayList<Employee> employees, String about_us) {
        this.name = name;
        //TODO controller si repo pt employees
        this.employees = employees;
        this.about_us = about_us;
        this.products=ProductController.getInstance().getStuff();
        for (Product product:products)
            product.registerObserver(this);
    }*/

    private Company() throws SQLException {
        this.name="BioLite";
        EmployeeController ec=new EmployeeController();
        this.employees = (ArrayList<Employee>) ec.getEmployeeRepo().findAll();
        ProductController pc=new ProductController();
        this.products= (ArrayList<Product>) pc.getStuff();
        for (Product product:products)
            product.registerObserver(this);

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
    public static Company getInstance() throws SQLException {
       //Company cmp_instance;
        if(cmp_instance==null)
            cmp_instance=new Company();
        return cmp_instance;
    }
}
