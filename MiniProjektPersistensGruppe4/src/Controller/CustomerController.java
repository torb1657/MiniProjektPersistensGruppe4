package Controller;
import java.sql.SQLException;
//
import java.util.List;

import Database.CustomerDatabase;
import Database.CustomerDatabaseInterface;
import Model.Customer;
//s
public class CustomerController {
	private CustomerDatabaseInterface customerDBINF;

	public CustomerController() throws SQLException {
		super();
		customerDBINF = new CustomerDatabase();
	}
	
	
	public List<Customer> findCustomersByName(String name){
		return customerDBINF.findCustomersByName(name);
	}

}
