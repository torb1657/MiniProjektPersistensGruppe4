package Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.Order;
import Model.OrderLine;

public class OrderDatabase implements OrderDatabaseInterface {

	private static final String PERSIST_ORDER_Q = "insert into order(orderDate, deliveryDate, orderAmount, customerIdFK) VALUES (?, ?, ?, ?)";
	private PreparedStatement persistOrderPS;
	private static final String PERSIST_ORDERLINE_Q = "insert into orderLine(quantity, subTotalPrice, productIdFK, orderIdFK) VALUES (?, ?, ?, ?)";
	private PreparedStatement persistOrderLinePS;
	private static final String CREATE_ORDER_Q = "select o.orderDate, o.deliveryDate, o.orderAmount, o.deliveryStatus, o.customerIdFK, ol.quantity, ol.subTotalPrice, ol.productIdFK\r\n" + 
			", ol.orderIdFK, p.name, p.purchasePrice, p.salesPrice, p.countryOfOrigin, p.minStock, p.productType\r\n" + 
			"from order_ as o, orderline as ol, product as p where o.orderId = ol.orderIdFK and ol.productIdFK = p.productId";
	private PreparedStatement createOrderPS;
	
	// enten joiner vi i sql kaldet, eller kalder hver for sig
	// først finde ordren, orderLiner og deri produkterne deri (mange gange eller en
	// gange)
	// det samme skal laves til en invoice

	public OrderDatabase() throws SQLException {
		init();
	}

	private void init() throws SQLException {
		Connection con = DBConnection.getInstance().getConnection();
		persistOrderPS = con.prepareStatement(PERSIST_ORDER_Q, Statement.RETURN_GENERATED_KEYS);
		persistOrderLinePS = con.prepareStatement(PERSIST_ORDERLINE_Q);
		createOrderPS = con.prepareStatement(CREATE_ORDER_Q);
	}

	private int persistTotalOrder(Order order) {

		try {
			DBConnection.getInstance().startTransaction();
			int orderId = persistOrder(order);
			for (OrderLine orderLine : order.getOrderLine()) {
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

	public Order createOrder(Order order) throws SQLException {
		int orderId = persistTotalOrder(order);
		
		/*createOrderPS.setDate(1, Date.valueOf(order.getDate()));
		createOrderPS.setDate(2, Date.valueOf(order.getDeliveryDate()));
		createOrderPS.setDouble(3, order.getAmount());
		createOrderPS.setBoolean(4, order.isDeliveryStatus());
		createOrderPS.setInt(5, order.getCustomer().getCustomerId());
		for(OrderLine orderLine: order.getOrderLine()) {
			
			 
			
		}*/
		
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
		persistOrderPS.setDate(1, Date.valueOf(order.getDate()));
		persistOrderPS.setDate(2, Date.valueOf(order.getDeliveryDate()));
		persistOrderPS.setDouble(3, order.getAmount());
		persistOrderPS.setInt(4, order.getCustomer().getCustomerId());
		persistOrderPS.executeUpdate(); // det kan være at man skal bruge execute hvor man executeLargeUpdate(sql,
										// columnNames)
		// skal lave en string array med 1 element (autogenerede nøgles navn i
		// databasen) orderId)

		ResultSet resultSet = persistOrderPS.getGeneratedKeys();
		return resultSet.getInt(1);

	}

	private void persistOrderLine(OrderLine orderLine, int orderId, int productId) throws SQLException {
		persistOrderLinePS.setInt(1, orderLine.getQuantity());
		persistOrderLinePS.setDouble(2, orderLine.getSubTotal());
		persistOrderLinePS.setInt(3, productId);
		persistOrderLinePS.setInt(4, orderId);
		persistOrderLinePS.execute();

	}

	public Order endOrder(Order order) {

		return null;
	}
	// get order
}
