package Database;

import Model.Product;

public interface ProductDatabaseInterface {

	Product findProductsByName(Product product);
	void deleteProductByName(String name);
	Product insertProduct(Product product);
}
