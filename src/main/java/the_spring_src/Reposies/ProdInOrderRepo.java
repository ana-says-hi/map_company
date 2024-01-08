package the_spring_src.Reposies;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;
import the_spring_src.Domains.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class ProdInOrderRepo implements JpaRepository<ProdInOrderEntity, Integer> {

    ArrayList<ProdInOrderEntity> pio_repo;

    public ProdInOrderRepo() throws SQLException {
        this.pio_repo = get_from_db();
    }

    public ArrayList<ProdInOrderEntity> get_from_db() throws SQLException {
        ArrayList<ProdInOrderEntity> our_pio = new ArrayList<>();
        //OrderRepo or = new OrderRepo();
        ProductRepo pr = new ProductRepo();
        try (
                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin","S3cret");
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef", "castravete");
                PreparedStatement statement = connection.prepareStatement("select * from \"Order_Product\"")
        ) {
            ResultSet selected_stuff = statement.executeQuery();
            while (selected_stuff.next()) {
                int idfactura = selected_stuff.getInt("idfactura");
                int idproduct = selected_stuff.getInt("idproduct");
                int cantitate = selected_stuff.getInt("cantitate");
                ProdInOrderEntity pio = new ProdInOrderEntity(idfactura, pr.getById(idproduct));
                //Order order = new Order(id, client, employee, totalprie, date, Status.valueOf(status), new BasicDelivery(id, date), new ArrayList<>());
                our_pio.add(pio);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Database Error");
        }
        return our_pio;
    }

    public ArrayList<Product> looking_for_order(Order order) {
        ArrayList<Product> result_pio = new ArrayList<>();
        for (ProdInOrderEntity pio : pio_repo) {
            if (pio.getOrder() == order.getId())
                result_pio.add(pio.getProduct());
        }
        return result_pio;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends ProdInOrderEntity> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends ProdInOrderEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<ProdInOrderEntity> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public ProdInOrderEntity getOne(Integer integer) {
        return null;
    }

    @Override
    public ProdInOrderEntity getById(Integer integer) {
        return null;
    }

    @Override
    public ProdInOrderEntity getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends ProdInOrderEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends ProdInOrderEntity> List<S> findAll(Example<S> example) {
        // Assuming ProdInOrderEntity has a field named 'idFactura'
        S probe = example.getProbe();

        if (probe != null) {
            ArrayList<ProdInOrderEntity> result_pio = new ArrayList<>();
            Integer idFactura = probe.getOrder();
            for (ProdInOrderEntity pio : pio_repo) {
                if (pio.getOrder()== idFactura)
                    result_pio.add(pio);
            }
            return (List<S>) result_pio;
        }
        return Collections.emptyList();
    }


    @Override
    public <S extends ProdInOrderEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends ProdInOrderEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends ProdInOrderEntity> long count(Example<S> example) {
        return pio_repo.size();
    }

    @Override
    public <S extends ProdInOrderEntity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends ProdInOrderEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends ProdInOrderEntity> S save(S pio) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef", "castravete");
                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin", "S3cret");
                PreparedStatement statement = connection.prepareStatement("INSERT INTO \"Order_Product\"(idfactura,idproduct,cantitate) VALUES (?,?,1)")
        ) {
            statement.setInt(1, pio.getOrder());
            statement.setInt(2, pio.getProduct().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            try {
                throw e;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        //pio.getOrder().addProduct(pio.getProduct());
        pio_repo.add(pio);
        return pio;
    }

    @Override
    public <S extends ProdInOrderEntity> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<ProdInOrderEntity> findById(Integer id) {
        return null;
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<ProdInOrderEntity> findAll() {
        return pio_repo;
    }

    @Override
    public List<ProdInOrderEntity> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return pio_repo.size();
    }

    @Override
    public void deleteById(Integer idfactura) {
        try (
                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin","S3cret");
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef", "castravete");
                PreparedStatement statement = connection.prepareStatement("delete from \"Order_Product\" where idfactura=(?)")
        ) {
            statement.setInt(1, idfactura);
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Database Error");
        }
        //select.execute("DELETE FROM \"Client\" WHERE id=\"c.id\" ");
        for (ProdInOrderEntity pio : pio_repo) {
            if (pio.getOrder() == idfactura)
                pio_repo.remove(pio);
        }
    }

    @Override
    public void delete(ProdInOrderEntity pio) {
        try (
                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin","S3cret");
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef", "castravete");
                PreparedStatement statement = connection.prepareStatement("delete from \"Order_Product\" where idfactura=(?) and idproduct=(?)")
        ) {
            statement.setInt(1, pio.getOrder());
            statement.setInt(2, pio.getProduct().getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Database Error");
        }
        //select.execute("DELETE FROM \"Client\" WHERE id=\"c.id\" ");
        //pio.getOrder().deleteProduct(pio.getProduct());
        pio_repo.remove(pio);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends ProdInOrderEntity> entities) {

    }

    @Override
    public void deleteAll() {
        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef", "castravete"); ///AICI CRAPA
                //PreparedStatement statement = connection.prepareStatement("delete from \"Product\" where id=(?)")
                Statement select = connection.createStatement();
        ) {
            select.execute("DELETE FROM \"Order_Product\"");
            pio_repo.removeAll(pio_repo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ProdInOrderEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<ProdInOrderEntity> findAll(Pageable pageable) {
        return null;
    }
}
