package Database;

import Model.Product;

public interface ProductDatabaseInterface {

	Product findProductByName(Product product);
	Product deleteProductByName(String name);
	Product insertProduct(Product product);
}
