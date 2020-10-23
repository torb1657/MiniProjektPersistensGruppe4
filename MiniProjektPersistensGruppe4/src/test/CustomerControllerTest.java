package test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import Controller.CustomerController;
import Model.Customer;

public class CustomerControllerTest {
	private CustomerController customerController;

	@Test
	public void customerControllerTest() throws SQLException {
		customerController = new CustomerController();
		List<Customer> customerList = customerController.findCustomersByName("ho");
		System.out.println(customerList);

	}
}
