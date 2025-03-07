package Controller;

import java.sql.SQLException;

import java.util.List;

import Database.CustomerDatabase;
import Database.CustomerDatabaseInterface;
import Model.Customer;

public class CustomerController {
	private CustomerDatabaseInterface customerDBINF;

	public CustomerController() throws SQLException {
		customerDBINF = new CustomerDatabase();
	}

	public List<Customer> findCustomersByName(String name) {
		return customerDBINF.findCustomersByName(name);
	}

}
