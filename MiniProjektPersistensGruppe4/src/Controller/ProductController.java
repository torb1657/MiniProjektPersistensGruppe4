package Controller;
//
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

public List<Product> findProductsByName(String name){
	return productDatabase.findProductsByName(name);
	
}

}