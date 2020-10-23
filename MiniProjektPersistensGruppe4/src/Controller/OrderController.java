package Controller;
//
import Database.OrderDatabase;
import Database.OrderDatabaseInterface;

import java.sql.SQLException;
import java.time.LocalDate;
import Model.Customer;
import Model.Invoice;
import Model.Order;
import Model.Product;

public class OrderController {


	private OrderDatabaseInterface orderDatabaseIF;
	

	public OrderController() throws SQLException {
		orderDatabaseIF = new OrderDatabase();
		
	}

	public Order endOrder(Order order) throws SQLException {
		//order.setDate(LocalDate.now());
		//order.setDeliveryDate(LocalDate.now().plusDays(14));
		//order.setDeliveryStatus(true);
		
		return orderDatabaseIF.createOrder(order);
	}
	
	public Order getOrder(int id) throws SQLException{
		return orderDatabaseIF.getOrder(id);
	}

	
	public void setDates(Order order) {
		order.setDate(LocalDate.now());
		order.setDeliveryDate(LocalDate.now());
	}
	
	public Invoice persistInvoice(Order order) {
		
		return null;
	}
	
	public void persistOrder(Order order) {
		
	}
	
	public void addOrderLine(int quantity, Product product) {
		
	}

	

}
