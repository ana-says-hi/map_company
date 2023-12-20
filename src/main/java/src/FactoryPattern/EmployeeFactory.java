package src.FactoryPattern;

import src.Domains.Employee;

public class EmployeeFactory {

    static EmployeeFactory em_instance;
    private int id=800000;

    private EmployeeFactory() {}

    public static EmployeeFactory getInstance(){
        if(em_instance==null)
            em_instance=new EmployeeFactory();
        return em_instance;
    }

    public Employee make_cl(String name, String password){
        Employee employee= new Employee(id, name, password);
        id++;
        return employee;
    }

}
