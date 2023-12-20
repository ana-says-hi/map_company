package the_spring_src.Reposies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import the_spring_src.Domains.Feedback;

@Repository
public abstract class FeedbackRepo implements JpaRepository<Feedback,Integer> {
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
//    public ArrayList<Feedback> get_from_db() throws SQLException {
//        ArrayList<Feedback> feedbacks=new ArrayList<>();
//        try (
//                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin","S3cret");
//                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "stef","castravete");
//                PreparedStatement statement = connection.prepareStatement("select * from \"Feedback\"")
//        ){
//            ResultSet selected_stuff= statement.executeQuery();
//            while(selected_stuff.next()){
//                int id=selected_stuff.getInt("id");
//                int idclient=selected_stuff.getInt("idClient");
//                int idprodus=selected_stuff.getInt("idproduct");
//                String message=selected_stuff.getString("message");
//                boolean type=selected_stuff.getBoolean("type");
//                Client client=(new ClientController()).find_by_id(idclient);
//                Product produs=(new ProductController()).find_by_id(idprodus);
//                Feedback feed= new Feedback(id,client,produs,message,type);
//                feedbacks.add(feed);
//            }
//        }
//        catch(SQLException ex) {
//            throw new RuntimeException("Database Error");
//        }
//        return feedbacks;
//    }

}
