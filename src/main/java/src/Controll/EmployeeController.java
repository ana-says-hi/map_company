package src.Controll;

import org.springframework.http.ResponseEntity;
import src.Domains.Employee;
import src.FactoryPattern.EmployeeFactory;
import src.Reposies.EmployeeRepo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import src.RequestStuff.EmployeeRequest;

import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employees = getEmployeeRepo().findAll();

        if (!employees.isEmpty()) {
            // Returnează lista de angajați în corpul răspunsului
            return ResponseEntity.ok(employees);
        } else {
            // Returnează un răspuns 404 Not Found dacă lista de angajați este goală
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public void create(@RequestBody EmployeeRequest request) {
        String name = request.getName();
        String password = request.getPassword();

        Employee employee = EmployeeFactory.getInstance().make_cl(name, password);
        //employeeRepo.add_to_repo(employee);
        employeeRepo.save(employee);
        // Returnează un răspuns 201 Created și angajatul creat în corpul răspunsului
        //return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}/employee")
    public ResponseEntity<Employee> find_by_id(@PathVariable int id) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);

        if (optionalEmployee.isPresent()) {
            // Returnează un răspuns 200 OK și angajatul găsit în corpul răspunsului
            return ResponseEntity.ok(optionalEmployee.get());
        } else {
            // Returnează un răspuns 404 Not Found dacă angajatul nu a fost găsit
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}/employee")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);

        if (optionalEmployee.isPresent()) {
            // Angajatul a fost găsit, îl eliminăm din repoziție
            employeeRepo.delete(optionalEmployee.get());

            // Returnăm un răspuns 204 No Content pentru a indica ștergerea cu succes
            return ResponseEntity.noContent().build();
        } else {
            // Returnăm un răspuns 404 Not Found dacă angajatul nu a fost găsit
            return ResponseEntity.notFound().build();
        }
    }

}