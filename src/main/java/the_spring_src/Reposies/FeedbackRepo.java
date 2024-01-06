package the_spring_src.Reposies;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;
import the_spring_src.Controll.ClientController;
import the_spring_src.Controll.ProductController;
import the_spring_src.Domains.Client;
import the_spring_src.Domains.Feedback;
import the_spring_src.Domains.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class FeedbackRepo implements JpaRepository<Feedback,Integer> {

    private ArrayList<Feedback> f_repo;
    private ClientRepo clientrepo;
    private ProductRepo producrepo;

    public FeedbackRepo() throws SQLException {
        this.f_repo = get_from_db();
        this.clientrepo = new ClientRepo();
        this.producrepo = new ProductRepo();
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Feedback> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Feedback> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Feedback> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Feedback getOne(Integer integer) {
        return null;
    }

    @Override
    public Feedback getById(Integer id) {
        for (Feedback feedback : f_repo) {
            if (feedback.getId() == id) {
                return feedback;
            }
        }
        return null;
    }

    @Override
    public Feedback getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Feedback> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Feedback> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Feedback> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Feedback> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Feedback> long count(Example<S> example) {
        return f_repo.size();
    }

    @Override
    public <S extends Feedback> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Feedback, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Feedback> S save(S f) {
        try (
                Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef","castravete");
                PreparedStatement statement = connection.prepareStatement("insert into \"Feedback\" (id,idclient,idproduct,message,type) values (?, ?, ?,?,?)")
        ) {
            statement.setInt(1, f.getId());
            statement.setInt(2, f.getClient().getId());
            statement.setInt(3, f.getProduct().getId());
            statement.setString(4, f.getMessage());
            statement.setBoolean(5,f.getType());
            statement.executeUpdate();
        } catch (SQLException e) {
            try {
                throw e;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        f_repo.add(f);
        return f;
    }

    @Override
    public <S extends Feedback> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Feedback> findById(Integer id) {
        for (Feedback feedback : f_repo) {
            if (feedback.getId() == id) {
                return Optional.of(feedback);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Feedback> findAll() {
        return f_repo;
    }

    @Override
    public List<Feedback> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return f_repo.size();
    }

    @Override
    public void deleteById(Integer integer) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef","castravete");
                PreparedStatement statement = connection.prepareStatement("delete from \"Feedback\" where id=(?)")
        ){
            statement.setInt(1, integer);
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Database Error");
        }
        f_repo.remove(integer);
    }

    @Override
    public void delete(Feedback f) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef","castravete");
                PreparedStatement statement = connection.prepareStatement("delete from \"Feedback\" where id=(?)")
        ){
            statement.setInt(1, f.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Database Error");
        }
        f_repo.remove(f);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Feedback> entities) {

    }

    @Override
    public void deleteAll() {
        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef", "castravete"); ///AICI CRAPA
                //PreparedStatement statement = connection.prepareStatement("delete from \"Product\" where id=(?)")
                Statement select = connection.createStatement();
        ) {
            select.execute("DELETE FROM \"Feedback\"");
            f_repo.removeAll(f_repo);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Feedback> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Feedback> findAll(Pageable pageable) {
        return null;
    }
//
//    private ArrayList<Feedback> f_repo=new ArrayList<>();
//
//    public FeedbackRepo() throws SQLException {
//        f_repo=get_from_db();
//    }
//    @Transactional
//    public void add_to_repo(Feedback f){
//        try (
//                Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef","castravete");
//                PreparedStatement statement = connection.prepareStatement("insert into \"Feedback\" (id,idclient,idproduct,message,type) values (?, ?, ?,?,?)")
//        ) {
//            statement.setInt(1, f.getId());
//            statement.setInt(2, f.getClient().getId());
//            statement.setInt(3, f.getProduct().getId());
//            statement.setString(4, f.getMessage());
//            statement.setBoolean(5,f.getType());
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            try {
//                throw e;
//            } catch (SQLException ex) {
//                throw new RuntimeException(ex);
//            }
//        }
//        f_repo.add(f);
//    }
//
//    @Transactional
//    public void remove_from_repo(Feedback f){
//        try (
//                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef","castravete");
//                PreparedStatement statement = connection.prepareStatement("delete from \"Feedback\" where id=(?)")
//        ){
//            statement.setInt(1, f.getId());
//            statement.executeUpdate();
//        } catch (SQLException ex) {
//            throw new RuntimeException("Database Error");
//        }
//        f_repo.remove(f);
//    }
//
//    @Transactional
//    public ArrayList<Feedback> get_repo() {
//        return f_repo;
//    }
//
//    @Override
//    @Transactional
    private ArrayList<Feedback> get_from_db() throws SQLException {
        ArrayList<Feedback> feedbacks=new ArrayList<>();
        try (
                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin","S3cret");
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef","castravete");
                PreparedStatement statement = connection.prepareStatement("select * from \"Feedback\"")
        ){
            ResultSet selected_stuff= statement.executeQuery();
            while(selected_stuff.next()){
                int id=selected_stuff.getInt("id");
                int idclient=selected_stuff.getInt("idClient");
                int idprodus=selected_stuff.getInt("idproduct");
                String message=selected_stuff.getString("message");
                boolean type=selected_stuff.getBoolean("type");
                Client client= (new ClientController()).find_by_id(idclient).getBody();
                Product produs= (new ProductController()).find_by_id(idprodus).getBody();
                Feedback feed= new Feedback(id,client,produs,message,type);
                feedbacks.add(feed);
            }
        }
        catch(SQLException ex) {
            throw new RuntimeException("Database Error");
        }
        return feedbacks;
    }

}
