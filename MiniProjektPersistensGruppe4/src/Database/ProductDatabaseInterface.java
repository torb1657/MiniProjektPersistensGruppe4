package Database;

import java.util.List;

import Model.Product;

public interface ProductDatabaseInterface {

	List<Product> findProductsByName(String name);
	void deleteProductByName(String name);
	Product insertProduct(Product product);
	Product findProductByName(String name);
}

