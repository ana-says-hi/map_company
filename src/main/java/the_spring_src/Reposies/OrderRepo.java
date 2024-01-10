package the_spring_src.Reposies;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import the_spring_src.Controll.EmployeeController;
import the_spring_src.Domains.*;
import org.springframework.stereotype.Repository;
import the_spring_src.Domains.Deliveries.BasicDelivery;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
//import org.checkerframework.checker.units.qual.C;

@Repository
public class OrderRepo implements JpaRepository<Order, Integer> {

    private ArrayList<Order> o_repo;
    private ProdInOrderRepo pio_repo;

    public OrderRepo() throws SQLException {
        this.o_repo = get_from_db();
        ProdInOrderRepo pio_repo = new ProdInOrderRepo();
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Order> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Order> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Order> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Order getOne(Integer integer) {
        return null;
    }

    @Override
    public Order getById(Integer id) {
        for (Order order : o_repo) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    @Override
    public Order getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Order> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Order> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Order> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Order> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Order> long count(Example<S> example) {
        return o_repo.size();
    }

    @Override
    public <S extends Order> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Order, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Order> S save(S o) {
        try (
                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin", "S3cret");
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef", "castravete");
                PreparedStatement statement = connection.prepareStatement("insert into \"Order\" (id,idemployee,idclient,totalprice,date,status,delivery) values (?, ?, ?,?,?,?,?)")
        ) {
            statement.setInt(1, o.getId());
            statement.setInt(2, o.getEmployee().getId());
            statement.setInt(3, o.getClient().getId());
            statement.setFloat(4, o.getTotalPrice());
            statement.setDate(5, Date.valueOf(o.getDate()));
            statement.setString(6, o.getStatus().toString());
            statement.setString(7, o.getDelivery().getExpectedDate().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            try {
                throw e;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            //throw new RuntimeException("Database Error");
        }
        o_repo.add(o);
        //select.execute("INSERT INTO \"Client\"(id,name,address) VALUES (\"c.id\",\"c.name\",\"c.address\") ");
        return o;
    }

    @Override
    public <S extends Order> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Order> findById(Integer id) {
        for (Order order : o_repo) {
            if (order.getId() == id) {
                return Optional.of(order);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Order> findAll() {
        return o_repo;
    }

    @Override
    public List<Order> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return o_repo.size();
    }

    @Override
    public void deleteById(Integer integer) {
        try (
                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin","S3cret");
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef", "castravete");
                //PreparedStatement statement = connection.prepareStatement("delete from \"Order\" where id=(?)")
                PreparedStatement statement = connection.prepareStatement("delete from \"Order\" where id=(?) ; delete from \"Order_Product\" where idfactura=(?)")
                //PreparedStatement statement_pio = connection.prepareStatement("delete from \"Order_Product\" where idfactura=(?)");
        ) {
            statement.setInt(1, integer);
            statement.setInt(2, integer);
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Database Error");
        }
        //select.execute("DELETE FROM \"Client\" WHERE id=\"c.id\" ");
        o_repo.remove(integer);
    }

    @Override
    public void delete(Order o) {
        try (
                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin","S3cret");
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef", "castravete");
                PreparedStatement statement = connection.prepareStatement("delete from \"Order\" where id=(?) ; delete from \"Order_Product\" where idfactura=(?)")
        ) {
            statement.setInt(1, o.getId());
            statement.setInt(2, o.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Database Error");
        }
        //select.execute("DELETE FROM \"Client\" WHERE id=\"c.id\" ");
        o_repo.remove(o);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Order> entities) {
    }

    @Override
    public void deleteAll() {
        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef", "castravete"); ///AICI CRAPA
                //PreparedStatement statement = connection.prepareStatement("delete from \"Product\" where id=(?)")
                Statement select = connection.createStatement();
        ) {
            select.execute("DELETE FROM \"Order\"");
            o_repo.removeAll(o_repo);
            pio_repo.deleteAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return null;
    }

    //
//    public OrderRepo() throws SQLException {
//        o_repo=get_from_db();
//    }
//
//    @Transactional
//    public void add_to_repo(Order o) {
//        try (
//                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin", "S3cret");
//                Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef","castravete");
//                PreparedStatement statement = connection.prepareStatement("insert into \"Order\" (id,idemployee,idclient,totalprice,date,status,delivery) values (?, ?, ?,?,?,?,?)")
//        ) {
//            statement.setInt(1, o.getId());
//            statement.setInt(2, o.getEmployee().getId());
//            statement.setInt(3, o.getClient().getId());
//            statement.setFloat(4, o.getTotalPrice());
//            statement.setDate(5,Date.valueOf(o.getDate()));
//            statement.setString(6,o.getStatus().toString());
//            statement.setString(7,"NULL");
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            try {
//                throw e;
//            } catch (SQLException ex) {
//                throw new RuntimeException(ex);
//            }
//            //throw new RuntimeException("Database Error");
//        }
//        o_repo.add(o);
//        //select.execute("INSERT INTO \"Client\"(id,name,address) VALUES (\"c.id\",\"c.name\",\"c.address\") ");
//    }
//
//    @Transactional
//    public void remove_from_repo(Order o) {
//        try (
//                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin","S3cret");
//                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef","castravete");
//                PreparedStatement statement = connection.prepareStatement("delete from \"Order\" where id=(?)")
//        ){
//            statement.setInt(1, o.getId());
//            statement.executeUpdate();
//        } catch (SQLException ex) {
//            throw new RuntimeException("Database Error");
//        }
//        //select.execute("DELETE FROM \"Client\" WHERE id=\"c.id\" ");
//        o_repo.remove(o);
//
//    }
//
//
//    @Transactional
//    public void add_product_to_order(Order o, Product p){
//        try (
//                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef","castravete");
//                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin", "S3cret");
//                PreparedStatement statement = connection.prepareStatement("INSERT INTO \"Order_Product\"(idfactura,idproduct,cantitate) VALUES (?,?,1)")
//        ) {
//            statement.setInt(1, o.getId());
//            statement.setInt(2, p.getId());
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            try {
//                throw e;
//            } catch (SQLException ex) {
//                throw new RuntimeException(ex);
//            }
//        }
//        o.addProduct(p);
//    }
//
//    @Transactional
//    public void delete_product_from_order(Order o, Product p) {
//        try (
//                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin","S3cret");
//                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef","castravete");
//                PreparedStatement statement = connection.prepareStatement("DELETE FROM \"Order_Product\" WHERE idfactura=(?) and idproduct=(?)")
//        ){
//            statement.setInt(1, o.getId());
//            statement.setInt(2, p.getId());
//            statement.executeUpdate();
//        } catch (SQLException ex) {
//            throw new RuntimeException("Database Error");
//        }
//        o.deleteProduct(p);
//        //select.execute("DELETE FROM \"Order_Product\" WHERE idfactura=\"o.id\" and idproduct=\"p.id\" ");
//    }
//
//    @Transactional
//    public ArrayList<Order> get_repo() {
//        return o_repo;
//    }
//
//    @Transactional
//    @Override
    private ArrayList<Order> get_from_db() throws SQLException {
        ArrayList<Order> our_orders = new ArrayList<>();
        ClientRepo cc = new ClientRepo();
        EmployeeRepo ec = new EmployeeRepo();

        try (
                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin","S3cret");
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef", "castravete");
                PreparedStatement statement = connection.prepareStatement("select * from \"Order\"")
        ) {
            ResultSet selected_stuff = statement.executeQuery();
            while (selected_stuff.next()) {
                int id = selected_stuff.getInt("id");
                int idemployee = selected_stuff.getInt("idemployee");
                int idclient = selected_stuff.getInt("idclient");
                float totalprie = selected_stuff.getFloat("totalprice");
                String status = selected_stuff.getString("status");
                LocalDate date = selected_stuff.getDate("date").toLocalDate();
                Employee employee = ec.getById(idemployee);
                Client client = cc.getById(idclient);
                Order order = new Order(id, client, employee, totalprie, date, Status.valueOf(status), new BasicDelivery(id, date), new ArrayList<>());
//                ProdInOrderEntity probe = new ProdInOrderEntity(order,null);
//                probe.setOrder(order);
//                order.setProducts(pio_repo.findAll(Example.of(probe));
                order.setProducts(pio_repo.looking_for_order(order));
                our_orders.add(order);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Database Error");
        }
        return our_orders;
    }

}
