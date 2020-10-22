package Database;
//
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Customer;


public class CustomerDatabase implements CustomerDatabaseInterface {
	private DBConnection dbConnection;
   	
	private static final String FIND_ALL_CUSTOMERS_BY_NAME_Q = "select c.customerId, c.firstName, c.lastName, c.minit from Customer c where c.firstName like ? or c.lastName like ? or"
			+ "c.minit like ?";
	private PreparedStatement findAllCustomersByNamePS;
	
	private static final String INSERT = "insert into Customer (phoneNo, lastName, name, middleName, address, zipCode, city) values (?, ?, ?, ?, ?, ?, ?)";
	private PreparedStatement insertPS;
	
	private static final String DELETE = "delete from Customer where name = ?";
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
	public List<Customer> buildObjects(ResultSet resultSet) throws SQLException {
		List<Customer> customerList = new ArrayList<>();
		
		while(resultSet.next()) {
		Customer customer = buildObject(resultSet);
		customerList.add(customer);
		}
		return customerList;
	}
	
	public Customer buildObject(ResultSet resultSet) throws SQLException {
		
			int customerId = resultSet.getInt("customerId");
			String lastName = resultSet.getString("lastName");
			String firstName = resultSet.getString("firstName");
			String middleName = resultSet.getString("minit");
			
			Customer customer = new Customer(customerId ,null, lastName, firstName, middleName, null, null, null);
//

		return customer;
	}
	
	@Override
	public List<Customer> findCustomersByName(String searchInput) {
		try {
			findAllCustomersByNamePS.setString(1, "%" + searchInput+ "%");
			findAllCustomersByNamePS.setString(2, "%" + searchInput+ "%");
			findAllCustomersByNamePS.setString(3, "%" + searchInput+ "%");
			
			
			ResultSet resultSet = findAllCustomersByNamePS.executeQuery();
			List<Customer> customerList = buildObjects(resultSet);
			return customerList;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public Customer insert(Customer customer) {
		try {
		insertPS.setString(1, customer.getPhoneNo());
		insertPS.setString(2, customer.getLastName());
		insertPS.setString(3, customer.getFirstName());
		insertPS.setString(4, customer.getMiddleName());
		insertPS.setString(5, customer.getAddress());
		insertPS.setString(6, customer.getZipCode());
		insertPS.setString(7, customer.getCity());
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			insertPS.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}
	@Override
	public void delete(String name) {
		try {
			deletePS.setString(3, name);
			deletePS.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



}