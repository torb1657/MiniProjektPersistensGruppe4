package Model;
//
import java.time.LocalDate;

public class Order {
	private LocalDate date;
	private int amount;
	private boolean deliveryStatus;
	private LocalDate deliveryDate;
	
	public Order(LocalDate date, int amount, boolean deliveryStatus, LocalDate deliveryDate) {
		this.date = date;
		this.amount = amount;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
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

	

}
