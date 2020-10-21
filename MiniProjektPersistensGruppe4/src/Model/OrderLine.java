package Model;
//
public class OrderLine {
	private int quantity;
	private double subTotal;

	public OrderLine(int quantity, double subTotal) {
		this.quantity = quantity;
		this.subTotal = subTotal;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

}
