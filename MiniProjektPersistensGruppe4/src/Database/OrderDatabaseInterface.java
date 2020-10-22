package Database;

import java.sql.SQLException;

import Model.Customer;
import Model.Order;

public interface OrderDatabaseInterface {

	Order createOrder(Order order) throws SQLException;
	Order getOrder(int id) throws SQLException;
}
