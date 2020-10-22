package test;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.Test;

import Controller.CustomerController;
import Controller.OrderController;
import Controller.ProductController;
import Model.Customer;
import Model.Order;
import Model.Product;

public class OrderControllerTest {
	private OrderController orderController;
	private ProductController productController;
	private CustomerController customerController;
	
	@Test
    public void orderControllerTest() throws SQLException {

        orderController = new OrderController();
        productController = new ProductController();
        customerController = new CustomerController();


        Product product = productController.findProductsByName("b").get(0);
        Customer customer = customerController.findCustomersByName("th").get(0);


        Order order = new Order(LocalDate.now(), 1.00, false, LocalDate.now(), customer);
        order.createOrderLine(1, product);
        order.createOrderLine(2, product);

        Order order1 = orderController.endOrder(order);
        System.out.println(order1);

    }

    @Test
    public void getOrderTest() throws SQLException {
        orderController = new OrderController();
        productController = new ProductController();
        customerController = new CustomerController();


        Order order = orderController.getOrder(1);
        System.out.println(order);

    }

}
