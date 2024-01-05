package the_spring_src.Reposies;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;
import the_spring_src.Domains.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static net.sf.jsqlparser.parser.feature.Feature.select;

@Repository
public class ProductRepo implements JpaRepository<Product, Integer> {

    private ArrayList<Product> p_repo;

    public Product save(Product p) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef", "castravete"); ///AICI CRAPA
                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin", "S3cret");
                //Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "stef","castravete");
                PreparedStatement statement = connection.prepareStatement("insert into \"Product\" (id,name,price,stoc,type) values (?, ?, ?,?,?)")
        ) {
            statement.setString(2, p.getName());
            statement.setFloat(3, p.getPrice());
            statement.setInt(4, p.getStoc());
            statement.setString(5, String.valueOf(p.getType()));
            // statement.setString(3, p.getAddress());
            statement.executeUpdate();
        } catch (SQLException e) {
            try {
                throw e;
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            //throw new RuntimeException("Database Error");
//        }
//        //select.execute("INSERT INTO \"Client\"(id,name,address) VALUES (\"c.id\",\"c.name\",\"c.address\") ");
//
        }
        p_repo.add(p);
        return p;
    }

    @Override
    public Product getById(Integer id) {
        for (Product product : p_repo) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public Optional<Product> findById(Integer id) {
        for (Product product : p_repo) {
            if (product.getId() == id) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    @Override
    public <S extends Product> List<S> findAll(Example<S> example) {
        return (List<S>) p_repo;
    }

    @Override
    public List<Product> findAll() {
        return p_repo;
    }

    @Override
    public List<Product> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return p_repo.size();
    }

    @Override
    public void deleteById(Integer integer) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef", "castravete"); ///AICI CRAPA
                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin", "S3cret");
                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "stef","castravete");
                PreparedStatement statement = connection.prepareStatement("delete from \"Product\" where id=(?)")
        ) {
            statement.setInt(1, integer);
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Database Error");
        }
        //select.execute("DELETE FROM \"Client\" WHERE id=\"c.id\" ");
        p_repo.remove(integer);
    }

    @Override
    public void delete(Product p) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef", "castravete"); ///AICI CRAPA
                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin", "S3cret");
                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "stef","castravete");
                PreparedStatement statement = connection.prepareStatement("delete from \"Product\" where id=(?)")
        ) {
            statement.setInt(1, p.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Database Error");
        }
        //select.execute("DELETE FROM \"Client\" WHERE id=\"c.id\" ");
        p_repo.remove(p);
    }

    @Override
    public void deleteAll() {
        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef", "castravete"); ///AICI CRAPA
               //PreparedStatement statement = connection.prepareStatement("delete from \"Product\" where id=(?)")
                Statement select = connection.createStatement();
        ) {
            select.execute("DELETE FROM \"Product\"");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <S extends Product> boolean exists(Example<S> example) {
        return false;
    }
    @Override
    public void flush() {

    }

    @Override
    public <S extends Product> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Product> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Product> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Product getOne(Integer integer) {
        return null;
    }


    @Override
    public Product getReferenceById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Product> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Product> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Product> long count(Example<S> example) {
        return p_repo.size();
    }


    @Override
    public <S extends Product, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Product> List<S> saveAll(Iterable<S> entities) {
        return null;
    }


    @Override
    public boolean existsById(Integer integer) {
        return false;
    }


    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Product> entities) {

    }


    @Override
    public List<Product> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return null;
    }

//
//
//    //fiecare cu conexiunea  lui ca sa nu se blocheze
////    Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "stef","castravete");
////    Statement select=connection.createStatement();
//
//    public ProductRepo() throws SQLException {
//        p_repo = get_from_db();
//    }
//
//    @Transactional
//    public void add_to_repo(Product p){
//        try (
//                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef", "castravete"); ///AICI CRAPA
//                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin", "S3cret");
//                //Connection connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "stef","castravete");
//                PreparedStatement statement = connection.prepareStatement("insert into \"Product\" (id,name,price,stoc,type) values (?, ?, ?,?,?)")
//        ) {
//            statement.setInt(1, p.getId());
//            statement.setString(2, p.getName());
//            statement.setFloat(3, p.getPrice());
//            statement.setInt(4, p.getStoc());
//            statement.setString(5, String.valueOf(p.getType()));
//            // statement.setString(3, p.getAddress());
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            try {
//                throw e;
//            } catch (SQLException ex) {
//                throw new RuntimeException(ex);
//            }
//            //throw new RuntimeException("Database Error");
//        }
//        p_repo.add(p);
//        //select.execute("INSERT INTO \"Client\"(id,name,address) VALUES (\"c.id\",\"c.name\",\"c.address\") ");
//    }
//
//    @Transactional
//    public void remove_from_repo(Product p) {
//        try (
//                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef", "castravete"); ///AICI CRAPA
//                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin", "S3cret");
//                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "stef","castravete");
//                PreparedStatement statement = connection.prepareStatement("delete from \"Product\" where id=(?)")
//        ) {
//            statement.setInt(1, p.getId());
//            statement.executeUpdate();
//        } catch (SQLException ex) {
//            throw new RuntimeException("Database Error");
//        }
//        //select.execute("DELETE FROM \"Client\" WHERE id=\"c.id\" ");
//        p_repo.remove(p);
//    }
//
//    @Transactional
//    public ArrayList<Product> get_repo() {
//        return p_repo;
//    }
//
//
//    @Transactional
//    public ArrayList<Product> get_from_db() throws SQLException {
//        ArrayList<Product> our_products = new ArrayList<>();
//        try (
//                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef", "castravete"); ///AICI CRAPA
//                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "admin","S3cret"); ///AICI CRAPA
//                PreparedStatement statement = connection.prepareStatement("select * from \"Product\"")
//        ) {
//            ResultSet selected_stuff = statement.executeQuery();
//            while (selected_stuff.next()) {
//                int id = selected_stuff.getInt("id");
//                String name = selected_stuff.getString("name");
//                float price = selected_stuff.getInt("price");
//                int stoc = selected_stuff.getInt("stoc");
//                String type = selected_stuff.getString("type");
//                Product product = new Product(id, name, price, ProductType.valueOf(type), stoc);
//                our_products.add(product);
//            }
//
//        } catch (SQLException ex) {
//            throw ex;
////            throw new RuntimeException("Database Error");
//        }
//        return our_products;
//    }
//
//    @Transactional
//    public ArrayList<Product> filterProductsByType(ProductType type) {
//        ArrayList<Product> filteredProducts = new ArrayList<>();
//        for (Product product : p_repo) {
//            if (product.getType() == type) {
//                filteredProducts.add(product);
//            }
//        }
//        return filteredProducts;
//    }
//
//    @Transactional
//    public void add(Product pr) {
//        p_repo.add(pr);
//    }
//
//
//    @Transactional
//    public void delete(Product pr) {
//        p_repo.remove(pr);
//    }
}