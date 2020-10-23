package test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import Controller.ProductController;
import Model.Product;

public class ProductControllerTest {
	private ProductController productController;

	@Test
	public void productControllerTest() throws SQLException {
		productController = new ProductController();
		List<Product> productList = productController.findProductsByName("b");
		System.out.println(productList);

	}

}
