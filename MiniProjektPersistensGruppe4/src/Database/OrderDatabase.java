package Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import Model.Customer;
import Model.Order;
import Model.OrderLine;
import Model.Product;

public class OrderDatabase implements OrderDatabaseInterface {

	private static final String PERSIST_ORDER_Q = "insert into order (orderDate, deliveryDate, orderAmount, customerIdFK) VALUES (?, ?, ?, ?)";
	private PreparedStatement persistOrderPS;
	private static final String PERSIST_ORDERLINE_Q = "insert into orderLine (quantity, subTotalPrice, productIdFK, orderIdFK) VALUES (?, ?, ?, ?)";
	private PreparedStatement persistOrderLinePS;
	private static final String GET_ORDER_Q = "select z.city, c.firstName, c.lastName, c.minit, c.phoneNumber, c.zipCodeCityFK, c.customerAddress, o.orderDate, o.orderAmount, o.deliveryStatus, o.deliveryDate, o.customerIdFK"
			+ " , ol.quantity, ol.subTotalPrice, ol.productIdFK, ol.orderIdFK, p.productName, p.purchasePrice, p.salesPrice, p.countryOfOrigin, p.minStock from orderTable as o, orderLine as ol, product as p, Customer as c, zipCode_city as z where z.zipCodeCity = c.zipCodeCityFK and c.customerId = o.customerIdFK"
			+ " and o.orderId = ol.orderIdFK and ol.productIdFK = p.productId and o.orderId = ?";
	private PreparedStatement getOrderPS;

	public OrderDatabase() throws SQLException {
		init();
	}

	private void init() throws SQLException {
		Connection con = DBConnection.getInstance().getConnection();
		persistOrderPS = con.prepareStatement(PERSIST_ORDER_Q, Statement.RETURN_GENERATED_KEYS);
		persistOrderLinePS = con.prepareStatement(PERSIST_ORDERLINE_Q);
		getOrderPS = con.prepareStatement(GET_ORDER_Q);
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
				throw new RuntimeException("transaction rollback");
			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}
		}
	}

	public Order getOrder(int id) throws SQLException {
		getOrderPS.setInt(1, id);
		ResultSet resultSet = getOrderPS.executeQuery();
		return buildOrder(resultSet);

	}

	public Order createOrder(Order order) throws SQLException {
		int orderId = persistTotalOrder(order);
		return getOrder(orderId);

	}

	private int persistOrder(Order order) throws SQLException {
		persistOrderPS.setDate(1, Date.valueOf(order.getDate()));
		persistOrderPS.setDate(2, Date.valueOf(order.getDeliveryDate()));
		persistOrderPS.setDouble(3, order.getAmount());
		persistOrderPS.setInt(4, order.getCustomer().getCustomerId());
		persistOrderPS.executeUpdate();
		ResultSet resultSet = persistOrderPS.getGeneratedKeys();
		resultSet.next();
		return resultSet.getInt(1);

	}

	private void persistOrderLine(OrderLine orderLine, int orderId, int productId) throws SQLException {
		persistOrderLinePS.setInt(1, orderLine.getQuantity());
		persistOrderLinePS.setDouble(2, orderLine.getSubTotal());
		persistOrderLinePS.setInt(3, productId);
		persistOrderLinePS.setInt(4, orderId);
		persistOrderLinePS.execute();

	}

	public Order buildOrder(ResultSet resultSet) throws SQLException {
		Order order = null;
		Customer customer = null;
		Map<Integer, Product> productsMap = new HashMap<>();

		while (resultSet.next()) {
			String city = resultSet.getString("city");
			String firstName = resultSet.getString("firstName");
			String lastName = resultSet.getString("lastName");
			String minit = resultSet.getString("minit");
			String phoneNumber = resultSet.getString("phoneNumber");
			String zipCodeCityFK = resultSet.getString("zipCodeCityFK");
			String customerAddress = resultSet.getString("customerAddress");
			LocalDate orderDate = resultSet.getDate("orderDate").toLocalDate();
			double orderAmount = resultSet.getDouble("orderAmount");
			boolean deliveryStatus = resultSet.getBoolean("deliveryStatus");
			LocalDate deliveryDate = resultSet.getDate("deliveryDate").toLocalDate();
			int customerIdFK = resultSet.getInt("customerIdFK");
			int quantity = resultSet.getInt("quantity");
			double subTotalPrice = resultSet.getDouble("subTotalPrice");
			int productIdFK = resultSet.getInt("productIdFK");
			int orderIdFK = resultSet.getInt("orderIdFK");
			String productName = resultSet.getString("productName");
			double purchasePrice = resultSet.getDouble("purchasePrice");
			double salesPrice = resultSet.getDouble("salesPrice");
			String countryOfOrigin = resultSet.getString("countryOfOrigin");
			int minStock = resultSet.getInt("minStock");

			if (customer == null) {
				customer = new Customer(customerIdFK, firstName, customerAddress, zipCodeCityFK, city, phoneNumber,
						lastName, minit);

			}
			if (order == null) {
				order = new Order(orderDate, orderAmount, deliveryStatus, deliveryDate, customer);
			}
			if (!productsMap.containsKey(productIdFK)) {
				Product product = new Product(productIdFK, productName, purchasePrice, salesPrice, countryOfOrigin,
						minStock);
				productsMap.put(productIdFK, product);
			}

			OrderLine orderLine = new OrderLine(quantity, subTotalPrice, productsMap.get(productIdFK));
			order.addOrderLine(orderLine);

		}
		return order;
	}

}
