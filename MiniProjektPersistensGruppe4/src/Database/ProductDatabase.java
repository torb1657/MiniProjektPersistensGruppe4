package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	@Override
	public Product findProductByName(Product product) {
		
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
			insertProductPS.setString(1, product.getName());
			insertProductPS.setDouble(2, product.getPurchasePrice());
			insertProductPS.setDouble(3, product.getSalesPrice());
			insertProductPS.setString(4, product.getCountryOfOrigin());
			insertProductPS.setInt(5, product.getMinOnStock());
			//insertProductPS.set(6, product.getProductType());

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
