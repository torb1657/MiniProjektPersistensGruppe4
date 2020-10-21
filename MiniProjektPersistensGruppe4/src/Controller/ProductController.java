package Controller;

import java.util.List;

import Database.ProductDatabase;
import Model.Product;

public class ProductController {
	private OrderController orderController;
	private ProductDatabase productDatabase;

	public ProductController(OrderController orderController, ProductDatabase productDatabase) {
		super();
		this.orderController = orderController;
		this.productDatabase = productDatabase;
	}

public Product findProductByName(Product product) {
	return product;
	
}

public List<Product> findProductsByName(Product product){
	return null;
	
}

}