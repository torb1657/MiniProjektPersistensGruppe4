package Controller;
import java.sql.SQLException;
//
import java.util.List;

import Database.ProductDatabase;
import Database.ProductDatabaseInterface;
import Model.Product;

public class ProductController {
	private ProductDatabaseInterface productDatabaseIF;

	public ProductController() throws SQLException {
		this.productDatabaseIF = new ProductDatabase();
	}

public List<Product> findProductsByName(String name){
	return productDatabaseIF.findProductsByName(name);
	
}

}