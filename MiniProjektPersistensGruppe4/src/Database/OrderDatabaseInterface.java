package Database;

import Model.Customer;
import Model.Order;

public interface OrderDatabaseInterface {

	Order createOrder(Customer customer);
	Order endOrder(Order order);
}
