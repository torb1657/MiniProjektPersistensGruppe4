package Database;
//
import java.util.List;

import Model.Customer;



public interface CustomerDatabaseInterface {

	List<Customer> findCustomersByName(String name);
	Customer insert(Customer customer);
	void delete(String name);
}
