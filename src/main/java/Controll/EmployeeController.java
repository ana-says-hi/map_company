package Controll;

import Domains.Client;
import Domains.Employee;
import FactoryPattern.ClientFactory;
import FactoryPattern.EmployeeFactory;
import Reposies.ClientRepo;
import Reposies.EmployeeRepo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/employee")
@Getter
@Setter
@NoArgsConstructor
public class EmployeeController implements Controller<Employee> {
    //ca sa nu facem acum implementare de comenzi bagam mesaj cum ca suntem
    //inafara progrramului/se fac renovari/modificari la sistem si revenim in 2 saptamani
    @Autowired
    private EmployeeRepo employeeRepo;

    //@GetMapping
    public EmployeeRepo getEmployeeRepo() {
        return employeeRepo;
    }

    @GetMapping
    public ArrayList<Employee> getEmployees() {
        return getEmployeeRepo().get_repo();
    }

    @PostMapping
    public void create(@RequestBody String name,@RequestBody String password) {
        Employee employee = EmployeeFactory.getInstance().make_cl(name, password);
        employeeRepo.add_to_repo(employee);
    }

    @GetMapping("/{id}/employee")
    public Employee find_by_id(@PathVariable int id) {
        for (Employee employee : employeeRepo.get_repo()) {
            if (employee.getId() == id)
                return employee;
        }
        return null;
    }

    //nu il apelam :)
    @Override
    @DeleteMapping("/{id}/employee")
    public void delete(@PathVariable int id) {
        Employee employee = find_by_id(id);
        if (employee != null)
            employeeRepo.remove_from_repo(employee);
    }
}