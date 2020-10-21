package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Product;

public class ProductDatabase implements ProductDatabaseInterface {
	private DBConnection dbConnection;
	
	private static final String FIND_PRODUCTS_BY_NAME = "select * from Products where ?";
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
		findProductsByNamePS = con.prepareStatement(FIND_PRODUCTS_BY_NAME);
		insertProductPS = con.prepareStatement(INSERT_Q);
		deleteProductByNamePS = con.prepareStatement(DELETE_Q);
	}

	@Override
	public Product findProductByName(Product product) {

		return null;
	}

	@Override
	public Product deleteProductByName(String name) {

		return null;
	}

	@Override
	public Product insertProduct(Product product) {
		
		return null;
	}

}
