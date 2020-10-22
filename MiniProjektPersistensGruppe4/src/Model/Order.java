package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
	private LocalDate date;
	private double amount;
	private boolean deliveryStatus;
	private LocalDate deliveryDate;
	private Customer customer;
	private List<OrderLine> orderLines;
	private Invoice invoice;
	
	public Order(LocalDate date, double amount, boolean deliveryStatus, LocalDate deliveryDate, Customer customer) {
		this.customer = customer;
		this.date = date;
		this.amount = amount;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
		orderLines = new ArrayList<>();
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(boolean deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderLine> getOrderLine() {
		return orderLines;
	}
	
	public void createOrderLine(int quantity, Product product) {
		double subTotal = product.getPurchasePrice() * quantity;
		OrderLine orderLine = new OrderLine(quantity, subTotal, product);
		orderLines.add(orderLine);
		
	}
	
	public void addOrderLine(OrderLine orderLine) {
		orderLines.add(orderLine);
		
	}
	public void createInvoice() {//ekstra til invoice skal i parameterene {
		 invoice = new Invoice(1, "123", 2); // invoice skal creates og måske kaldes med nogle parameter (det meste ligger inde i orderen)
	}

}
