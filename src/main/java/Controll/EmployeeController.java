package Controll;

import Domains.Employee;
import Reposies.EmployeeRepo;

public class EmployeeController implements Controller<Employee>{
    //ca sa nu facem acum implementare de comenzi bagam mesaj cum ca suntem
    //inafara progrramului/se fac renovari/modificari la sistem si revenim in 2 saptamani

    private static EmployeeController em_instance;

    private EmployeeRepo employeeRepo;

    private EmployeeController() {
        employeeRepo = new EmployeeRepo();
    }

    //public ArrayList<Client> getClients(){return getClientRepo().getC_repo();}
   // private static List<Product> productsWithFeedbacks = new ArrayList<>();
    public static EmployeeController getInstance(){
        if(em_instance==null)
            em_instance=new EmployeeController();
        return em_instance;
    }

    public EmployeeRepo getEmployeeRepo() {
        return employeeRepo;
    }

    public void create(int clientID, String name, String password) {
        Employee employee=new Employee(clientID,name,password);
        employeeRepo.add_to_repo(employee);
    }

    public Employee find_by_id(int id) {
        for(Employee employee: employeeRepo.get_repo()) {
            if (employee.getId()==id)
                return employee;
        }
        return null;
    }
    //nu il apelam :)
    @Override
    public void delete(int id) {
        Employee employee= find_by_id(id);
        if(employee!=null)
            employeeRepo.remove_from_repo(employee);
    }
}