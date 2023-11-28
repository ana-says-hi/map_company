package Reposies;

import Domains.Employee;
import FactoryPattern.EmployeeFactory;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeRepo implements Repository<Employee> {

    private ArrayList<Employee> e_repo;

    public EmployeeRepo(){
        e_repo=new ArrayList<>();
        Employee e1= EmployeeFactory.getInstance().make_cl("Annaaa","Ania1234");
        Employee e2= EmployeeFactory.getInstance().make_cl("Steff","Stef2205");
        Employee e3= EmployeeFactory.getInstance().make_cl("Bogdie","hokedo");
        e_repo.add(e1);
        e_repo.add(e2);
        e_repo.add(e3);
    }

    public void add_to_repo(Employee e){
        e_repo.add(e);
    }

    public void remove_from_repo(Employee e){
        e_repo.remove(e);
    }

    public ArrayList<Employee> get_repo() {
        return e_repo;
    }

    @Override
    public ArrayList<Employee> get_from_db() throws SQLException {
        return null;
    }
}

//    public String covertToString(List<Employee> liste) {
//        List<String> lines = new ArrayList<>();
//        for (Employee employee : liste) {
//            lines.add(employee.toString());
//        }
//        return String.join("\n", lines);
   // }

//TODO foloseste repo.tostring nu ProdustToString

