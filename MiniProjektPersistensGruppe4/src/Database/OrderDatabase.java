package Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Customer;
import Model.Order;
import Model.OrderLine;

public class OrderDatabase implements OrderDatabaseInterface {

	private static final String CREATE_ORDER_Q = "insert into order(orderDate, deliveryDate, orderAmount, customerIdFK) VALUES (?, ?, ?, ?)";
	private PreparedStatement createOrderPS;
	private static final String CREATE_ORDER_LINE_Q = "insert into orderLine(quantity, subTotalPrice, productIdFK, orderIdFK) VALUES (?, ?, ?, ?)";
	private PreparedStatement createOrderLinePS;
	// enten joiner vi i sql kaldet, eller kalder hver for sig
	// først finde ordren, orderLiner og deri produkterne deri (mange gange eller en
	// gange)
	// det samme skal laves til en invoice

	public OrderDatabase() throws SQLException {
		init();
	}

	private void init() throws SQLException {
		Connection con = DBConnection.getInstance().getConnection();
		createOrderPS = con.prepareStatement(CREATE_ORDER_Q, Statement.RETURN_GENERATED_KEYS);
		createOrderLinePS = con.prepareStatement(CREATE_ORDER_LINE_Q);
	}

	private int persistTotalOrder(Order order) {

		try {
			DBConnection.getInstance().startTransaction();
			int orderId = persistOrder(order);
			for (OrderLine orderLine : order.getOrderLines()) {
				persistOrderLine(orderLine, orderId, orderLine.getProduct().getProductId());
			}
			DBConnection.getInstance().commitTransaction();
			return orderId;
		} catch (SQLException e) {
			try {
				DBConnection.getInstance().rollbackTransaction();
				throw new RuntimeException("transaction rollback");// overvej om der skal alves en mere sigenede
																	// exception
			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}
		}
	}

	private Order getOrder(int id) {
		return null;

	}

	public Order createOrder(Order order) {
		int orderId = persistTotalOrder(order);
		return getOrder(orderId);
		// der skal joines ordre, orderliner og produkt (invoice)
		// det jeg skal have retur ved den join er linjer svarende til antal ordreliner
		// på hver linje er der en union af ordre information, produktets information og
		// ordrelinje
		// kald hver eneste parameter as et eller andet, sådan parameterne i joinet
		// hedder noget
		// select o.name, o.:::, ol., p.name.. from order as o, orderline as ol, product
		// as p, where o.orderId = orderLineiDFK og ordelineIdFK = productId
	}

	private int persistOrder(Order order) throws SQLException {
		createOrderPS.setDate(1, Date.valueOf(order.getDate()));
		createOrderPS.setDate(2, Date.valueOf(order.getDeliveryDate()));
		createOrderPS.setDouble(3, order.getAmount());
		createOrderPS.setInt(4, order.getCustomer().getCustomerId());
		createOrderPS.executeUpdate(); // det kan være at man skal bruge execute hvor man executeLargeUpdate(sql,
										// columnNames)
		// skal lave en string array med 1 element (autogenerede nøgles navn i
		// databasen) orderId)

		ResultSet resultSet = createOrderPS.getGeneratedKeys();
		return resultSet.getInt(1);

	}

	private void persistOrderLine(OrderLine orderLine, int orderId, int productId) throws SQLException {
		createOrderLinePS.setInt(1, orderLine.getQuantity());
		createOrderLinePS.setDouble(2, orderLine.getSubTotal());
		createOrderLinePS.setInt(3, productId);
		createOrderLinePS.setInt(4, orderId);
		createOrderLinePS.execute();

	}

	public Order endOrder(Order order) {

		return null;
	}
	// get order
}
