package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Customer;
import Model.Product;

public class ProductDatabase implements ProductDatabaseInterface {
	private DBConnection dbConnection;
	
	private static final String FIND_PRODUCTS_BY_NAME_Q = "select * from Products where ?";
	private PreparedStatement findProductsByNamePS;
	
	private static final String DELETE_Q = "delete from Products where ?";
	private PreparedStatement deleteProductByNamePS;
	
	private static final String INSERT_Q = "insert into Products where ?";
	private PreparedStatement insertProductPS;
	
	public ProductDatabase() throws SQLException {
		init();
	}
	
	private void init() throws SQLException {
		Connection con = DBConnection.getInstance().getConnection();
		findProductsByNamePS = con.prepareStatement(FIND_PRODUCTS_BY_NAME_Q);
		insertProductPS = con.prepareStatement(INSERT_Q);
		deleteProductByNamePS = con.prepareStatement(DELETE_Q);
	}

	public List<Product> buildObjects(ResultSet resultSet) throws SQLException {
		List<Product> productList = new ArrayList<>();
		
		while(resultSet.next()) {
		Product product = buildObject(resultSet);
		productList.add(product);
		}
		return productList;
	}
	
	public Product buildObject(ResultSet resultSet) throws SQLException {

		String name = resultSet.getString("name");
		double purchasePrice = resultSet.getDouble("purchasePrice");
		double salesPrice = resultSet.getDouble("salesPrice");
		String countryOfOrigin = resultSet.getString("countryOfOrigin");
		int minOnStock = resultSet.getInt("minOnStock");
		
		Product product = new Product(name, purchasePrice, salesPrice, countryOfOrigin, minOnStock);

	return product;
		
}
	
	@Override
	public List<Product> findProductsByName(String name) {
		try {
			ResultSet resultSet = findProductsByNamePS.executeQuery();
			List<Product> productList = buildObjects(resultSet);
			return productList;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteProductByName(String name) {
		try {
			deleteProductByNamePS.setString(1, name);
			deleteProductByNamePS.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
	

	@Override
	public Product insertProduct(Product product) {
		try {
			insertProductPS.setString(2, product.getName());
			insertProductPS.setDouble(3, product.getPurchasePrice());
			insertProductPS.setDouble(4, product.getSalesPrice());
			insertProductPS.setString(5, product.getCountryOfOrigin());
			insertProductPS.setInt(6, product.getMinOnStock());

		}catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				insertProductPS.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return product;
	}
}
