package Database;

import java.util.List;

import Model.Customer;

public class CustomerDatabase implements CustomerDatabaseInterface {
	private DBConnection dbConnection;
	private FIND_ALL_CUSTOMERS_BY_NAME_Q = "select * from Customers where ?";


	public CustomerDatabase() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public List<Customer> findCustomersByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Customer insert(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Customer delete(String name) {
		// TODO Auto-generated method stub
		return null;
	}



}