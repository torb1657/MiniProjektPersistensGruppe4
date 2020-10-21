package Controller;

import Database.OrderDatabase;
import java.time.LocalDate;
import Model.Customer;
import Model.Invoice;
import Model.Order;
import Model.Product;

public class OrderController {


	private ProductController productController;
	private OrderDatabase orderDatabase;
	private CustomerController customerController;
	

	public OrderController(ProductController productController, OrderDatabase orderDatabase,
			CustomerController customerController) {
		super();
		this.productController = productController;
		this.orderDatabase = orderDatabase;
		this.customerController = customerController;
	}

	public Order endOrder(Order order) {
		
		
		return order;
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
