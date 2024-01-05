package the_spring_src.Reposies;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import the_spring_src.Domains.Employee;
import org.springframework.stereotype.Repository;
import the_spring_src.FactoryPattern.EmployeeFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class EmployeeRepo implements JpaRepository<Employee,Integer> {

    private ArrayList<Employee> e_repo;

    public EmployeeRepo() {
        this.e_repo = new ArrayList<>();
        Employee e1= EmployeeFactory.getInstance().make_cl("Annaaa","Ania1234");
        Employee e2= EmployeeFactory.getInstance().make_cl("Steff","Stef2205");
        Employee e3= EmployeeFactory.getInstance().make_cl("Bogdie","hokedo");
        e_repo.add(e1);
        e_repo.add(e2);
        e_repo.add(e3);
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Employee> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Employee> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Employee> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Employee getOne(Integer integer) {
        return null;
    }

    @Override
    public Employee getById(Integer id) {
        for (Employee employee : e_repo) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public Employee getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Employee> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Employee> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Employee> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Employee> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Employee> long count(Example<S> example) {
        return e_repo.size();
    }

    @Override
    public <S extends Employee> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Employee, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Employee> S save(S e) {
        try (
                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin","S3cret");
                Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef","castravete");
                PreparedStatement statement = connection.prepareStatement("insert into \"Employee\" (id,name,password) values (?, ?, ?)")
        ) {
            statement.setInt(1, e.getId());
            statement.setString(2, e.getName());
            statement.setString(3, e.getPassword());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Database Error");
        }
        e_repo.add(e);
        //select.execute("INSERT INTO \"Client\"(id,name,address) VALUES (\"c.id\",\"c.name\",\"c.address\") ");
        return e;
    }

    @Override
    public <S extends Employee> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        for (Employee employee : e_repo) {
            if (employee.getId() == id) {
                return Optional.of(employee);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Employee> findAll() {
        return e_repo;
    }

    @Override
    public List<Employee> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return e_repo.size();
    }

    @Override
    public void deleteById(Integer integer) {
        try (
                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin","S3cret");
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef","castravete");
                PreparedStatement statement = connection.prepareStatement("delete from \"Employee\" where id=(?)")
        ){
            statement.setInt(1, integer);
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Database Error");
        }
        //select.execute("DELETE FROM \"Client\" WHERE id=\"c.id\" ");
        e_repo.remove(integer);
    }

    @Override
    public void delete(Employee e) {
        try (
                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin","S3cret");
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef","castravete");
                PreparedStatement statement = connection.prepareStatement("delete from \"Employee\" where id=(?)")
        ){
            statement.setInt(1, e.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Database Error");
        }
        //select.execute("DELETE FROM \"Client\" WHERE id=\"c.id\" ");
        e_repo.remove(e);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Employee> entities) {
    }

    @Override
    public void deleteAll() {
        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef", "castravete"); ///AICI CRAPA
                //PreparedStatement statement = connection.prepareStatement("delete from \"Product\" where id=(?)")
                Statement select = connection.createStatement();
        ) {
            select.execute("DELETE FROM \"Employee\"");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return null;
    }
//
//    private ArrayList<Employee> e_repo;
//
//    public EmployeeRepo(){
//        e_repo=new ArrayList<>();
////        Employee e1= EmployeeFactory.getInstance().make_cl("Annaaa","Ania1234");
////        Employee e2= EmployeeFactory.getInstance().make_cl("Steff","Stef2205");
////        Employee e3= EmployeeFactory.getInstance().make_cl("Bogdie","hokedo");
////        e_repo.add(e1);
////        e_repo.add(e2);
////        e_repo.add(e3);
//    }
//
//    @Transactional
//    public void add_to_repo(Employee e) {
//        try (
//                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin","S3cret");
//                Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef","castravete");
//                PreparedStatement statement = connection.prepareStatement("insert into \"Employee\" (id,name,password) values (?, ?, ?)")
//        ) {
//            statement.setInt(1, e.getId());
//            statement.setString(2, e.getName());
//            statement.setString(3, e.getPassword());
//            statement.executeUpdate();
//        } catch (SQLException ex) {
//            throw new RuntimeException("Database Error");
//        }
//        e_repo.add(e);
//        //select.execute("INSERT INTO \"Client\"(id,name,address) VALUES (\"c.id\",\"c.name\",\"c.address\") ");
//    }
//
//    @Transactional
//    public void remove_from_repo(Employee e){
//        try (
//                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin","S3cret");
//                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef","castravete");
//                PreparedStatement statement = connection.prepareStatement("delete from \"Employee\" where id=(?)")
//        ){
//            statement.setInt(1, e.getId());
//            statement.executeUpdate();
//        } catch (SQLException ex) {
//            throw new RuntimeException("Database Error");
//        }
//        //select.execute("DELETE FROM \"Client\" WHERE id=\"c.id\" ");
//        e_repo.remove(e);
//    }
//
//
//    @Transactional
//    public ArrayList<Employee> get_repo() {
//        return e_repo;
//    }
//
//    @Override
//    @Transactional
//    public ArrayList<Employee> get_from_db() throws SQLException {
//        return null;
//    }
}


