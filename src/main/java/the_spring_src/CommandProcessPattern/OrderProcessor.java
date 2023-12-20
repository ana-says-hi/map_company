package the_spring_src.CommandProcessPattern;

import the_spring_src.Domains.Order;
import the_spring_src.Domains.Status;
import the_spring_src.Reposies.OrderRepo;

import java.sql.SQLException;

public class OrderProcessor extends CommandProcessor{

    private Order order; // Assuming there is an Order class
    private OrderRepo orderRepo;
    public OrderProcessor(Order order, OrderRepo orderRepo) throws SQLException {
        this.order = order;
        this.orderRepo=orderRepo;
    }

    @Override
    protected void validateCommand() {
        if (!order.getProducts().isEmpty()) {
            System.out.println("Comanda a fost validata.");
        } else {
            System.out.println("Nu s-a putut valida comanda. Nu exista produse.");
            throw new IllegalStateException("Cumparati macar un produs!");
        }
    }

    @Override
    protected void executeCommand() {
        order.setStatus(Status.CONFIRMED);
        order.setTotalPrice(order.getTotalPrice()+order.getDelivery().getShippinfFee());
    }

    @Override
    protected void logCommand() {
        Order order1=this.order;
        //orderRepo.remove_from_repo(this.order);
        orderRepo.delete(this.order);
        Order o=new Order(order1.getId(),order1.getClient(),order1.getEmployee(),order1.getTotalPrice(),order1.getDate(),order1.getStatus(),order1.getDelivery(),order1.getProducts());
        //orderRepo.add_to_repo(o);
        orderRepo.save(o);
    }
}
