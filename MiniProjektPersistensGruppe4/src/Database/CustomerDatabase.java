package Database;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Customer;

//test
public class CustomerDatabase implements CustomerDatabaseInterface {
	private DBConnection dbConnection;
   	
	private static final String FIND_ALL_CUSTOMERS_BY_NAME_Q = "select * from Customers where ?";
	private PreparedStatement findAllCustomersByNamePS;
	
	private static final String INSERT = "insert";
	private PreparedStatement insertPS;
	
	private static final String DELETE = "delete from Customer";
	private PreparedStatement deletePS;


	public CustomerDatabase() throws SQLException {
		// TODO Auto-generated constructor stub
		init();
	}
	
	private void init() throws SQLException {
		Connection con = DBConnection.getInstance().getConnection();
		findAllCustomersByNamePS = con.prepareStatement(FIND_ALL_CUSTOMERS_BY_NAME_Q);
		insertPS = con.prepareStatement(INSERT);
		deletePS = con.prepareStatement(DELETE);
	}
	
	// Build objects
	public List<Customer> buildCustomers(ResultSet resultSet) throws SQLException {
		List<Customer> customerList = new ArrayList<>();
		
		while(resultSet.next()) {
		Customer customer = buildCustomer(resultSet);
		customerList.add(customer);
		}
		return customerList;
	}
	
	public Customer buildCustomer(ResultSet resultSet) throws SQLException {
		
		String phoneNumber = resultSet.getString("phoneNumber");
		String lastName = resultSet.getString("lastName");
		String firstName = resultSet.getString("firstName");
		String minit = resultSet.getString("minit");
		String zipCodeCityFK = resultSet.getString("zipCodeCityFK");
		
		Customer customer = new Customer(phoneNumber, lastName, firstName, minit, zipCodeCityFK);
		return customer;
	}
	
	@Override
	public List<Customer> findCustomersByName(String name) {
		try {
			ResultSet resultSet = findAllCustomersByNamePS.executeQuery();
			List<Customer> customerList = buildCustomers(resultSet);
			return customerList;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
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