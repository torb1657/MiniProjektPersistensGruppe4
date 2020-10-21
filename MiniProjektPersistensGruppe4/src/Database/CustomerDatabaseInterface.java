package Database;

import java.util.List;

import Model.Customer;



public interface CustomerDatabaseInterface {

	List<Customer> findCustomersByName(String name);
	Customer insert(Customer customer);
	Customer delete(String name);
}
