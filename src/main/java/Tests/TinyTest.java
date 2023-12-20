package Tests;

import src.Domains.Client;
import src.Domains.Deliveries.BasicDelivery;
import src.Domains.Deliveries.SameDayDelivery;
import src.Domains.Employee;
import src.Domains.Order;
import src.Domains.Product;
import src.Reposies.ProductRepo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import static src.Domains.ProductType.hair;

public class TinyTest {
    public void test_delivery() {
        Client client = new Client(1, "Bob", "TheZobStreet 123");
        Employee employee = new Employee(2, "Dob", "1234");
        Order order = new Order(1, client, employee, LocalDate.now());
        assert order.getDelivery().getClass() == BasicDelivery.class;
        assert order.getDate() != order.getDelivery().getExpectedDate();
        order.setDelivery(new SameDayDelivery(order.getId(), order.getDate()));
        assert order.getDelivery().getClass() == SameDayDelivery.class;
        assert order.getDate() == order.getDelivery().getExpectedDate();
    }
    public void test_repo_conn() {
        ProductRepo repo;
        try {
            repo = new ProductRepo();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        add_to_repo(repo);
        remove_from_repo(repo);
    }

    public void add_to_repo(ProductRepo repo){
        Product p1 = new Product (123,"BioLite Curly Hair Mask", 78, hair, 5019);
        Product p2 = new Product(124,"BioLite Curly Hair Shampoo", 78, hair, 20);
        Product p3 = new Product(125,"BioLite Curly Hair Conditioner", 65, hair, 5021);
        Product p4 = new Product(126,"BioLite Soft Bath Towel", 95, hair, 502);
        Product p5 = new Product(127,"BioLite Organic Argan Oil", 50, hair, 50);
        repo.add_to_repo(p1);
        repo.add_to_repo(p2);
        repo.add_to_repo(p3);
        repo.add_to_repo(p4);
        repo.add_to_repo(p5);
        try (
                Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BioLite", "admin", "S3cret"); ///AICI CRAPA
                //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "admin","S3cret"); ///AICI CRAPA
                PreparedStatement statement = connection.prepareStatement("select * from \"Product\"")
        ) {
            ArrayList<Product> arrayList1 = repo.get_repo();
            assert arrayList1.contains(p1);
            assert arrayList1.contains(p2);
            assert arrayList1.contains(p3);
            assert arrayList1.contains(p4);
            assert arrayList1.contains(p5);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove_from_repo(ProductRepo repo){
        Product p1 = new Product (123,"BioLite Curly Hair Mask", 78, hair, 5019);
        Product p2 = new Product(124,"BioLite Curly Hair Shampoo", 78, hair, 20);
        Product p3 = new Product(125,"BioLite Curly Hair Conditioner", 65, hair, 5021);
        Product p4 = new Product(126,"BioLite Soft Bath Towel", 95, hair, 502);
        Product p5 = new Product(127,"BioLite Organic Argan Oil", 50, hair, 50);

        repo.remove_from_repo(p1);
        repo.remove_from_repo(p2);
        repo.remove_from_repo(p3);
        repo.remove_from_repo(p4);
        repo.remove_from_repo(p5);

        ArrayList<Product> arrayList2 = repo.get_repo();
        assert arrayList2.contains(p1);
        assert arrayList2.contains(p2);
        assert arrayList2.contains(p3);
        assert arrayList2.contains(p4);
        assert arrayList2.contains(p5);
    }
}
