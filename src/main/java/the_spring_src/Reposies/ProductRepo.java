package the_spring_src.Reposies;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public abstract class ProductRepo implements JpaRepository{

//    private ArrayList<Product> p_repo;
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