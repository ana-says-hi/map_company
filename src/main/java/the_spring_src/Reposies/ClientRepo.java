package the_spring_src.Reposies;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import the_spring_src.Domains.Client;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class ClientRepo implements JpaRepository<Client, Integer> {

    private ArrayList<Client> c_repo;

    @Override
    public long count() {
        return c_repo.size();
    }

    @Override
    public <S extends Client> long count(Example<S> example) {
        return c_repo.size();
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Client entity) {

    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Client> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Client> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Client> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Client getOne(Integer integer) {
        return null;
    }

    @Override
    public Client getById(Integer integer) {
        return null;
    }

    @Override
    public Client getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Client> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Client> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Client> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Client> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Client> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Client, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Client> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Client> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Client> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public List<Client> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Client> entities) {

    }

    @Override
    public void deleteAll() {
        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef", "castravete"); ///AICI CRAPA
                //PreparedStatement statement = connection.prepareStatement("delete from \"Product\" where id=(?)")
                Statement select = connection.createStatement();
        ) {
            select.execute("DELETE FROM \"Client\"");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Client> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Client> findAll(Pageable pageable) {
        return null;
    }
//
//    private ArrayList<Client> c_repo;
//
//    public ClientRepo() throws SQLException {
//        c_repo=get_from_db();
//    }
//
//    @Transactional
//    public void add_to_repo(Client c) {
//        try (
//                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin","S3cret");
//                Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef","castravete");
//                PreparedStatement statement = connection.prepareStatement("insert into \"Client\" (id,name,address) values (?, ?, ?)")
//        ) {
//            statement.setInt(1, c.getId());
//            statement.setString(2, c.getName());
//            statement.setString(3, c.getAddress());
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException("Database Error");
//        }
//        c_repo.add(c);
//        //select.execute("INSERT INTO \"Client\"(id,name,address) VALUES (\"c.id\",\"c.name\",\"c.address\") ");
//    }
//
//    @Transactional
//    public void remove_from_repo(Client c){
//        try (
//                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin","S3cret");
//                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef","castravete");
//                PreparedStatement statement = connection.prepareStatement("delete from \"Client\" where id=(?)")
//        ){
//            statement.setInt(1, c.getId());
//            statement.executeUpdate();
//        } catch (SQLException ex) {
//            throw new RuntimeException("Database Error");
//        }
//        //select.execute("DELETE FROM \"Client\" WHERE id=\"c.id\" ");
//        c_repo.remove(c);
//    }
//
//    @Transactional
//    public ArrayList<Client> get_repo() {
//        return c_repo;
//    }
//
//    @Override
//    @Transactional
//    public ArrayList<Client> get_from_db() throws SQLException {
//        ArrayList<Client> our_clients=new ArrayList<>();
//        try (
//                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin","S3cret");
//                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef","castravete");
//                PreparedStatement statement = connection.prepareStatement("select * from \"Client\"")
//        ){
//            ResultSet selected_stuff= statement.executeQuery();
//            while(selected_stuff.next()){
//                int id=selected_stuff.getInt("id");
//                String name=selected_stuff.getString("name");
//                String address=selected_stuff.getString("address");
//                Client client=new Client(id,name,address);
//                our_clients.add(client);
//            }
//        }
//        catch(SQLException ex) {
//            throw new RuntimeException("Database Error");
//        }
//        return our_clients;
//    }

}
