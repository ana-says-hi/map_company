package Reposies;

import Domains.Client;
import Domains.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo implements Repository {

    private ArrayList<Employee> e_repo;

    public EmployeeRepo(){
        e_repo=new ArrayList<>();
    }

    public void add_to_repo(Employee e){
        e_repo.add(e);
    }

    public void remove_from_repo(Employee e){
        e_repo.remove(e);
    }

    public ArrayList<Employee> getE_repo() {
        return e_repo;
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

