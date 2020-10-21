package Controller;

import java.util.List;

import Database.CustomerDatabase;
import Model.Customer;

public class CustomerController {
	private CustomerDatabase customerDatabase;
	private OrderController orderController;

	public CustomerController(CustomerDatabase customerDatabase, OrderController orderController) {
		super();
		this.customerDatabase = customerDatabase;
		this.orderController = orderController;
	}
	
	
	public List<Customer> findCustomersByName(String name){
		return customerDatabase.findCustomersByName(name);
	}

}
