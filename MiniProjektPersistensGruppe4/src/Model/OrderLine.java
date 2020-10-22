package Model;
//
public class OrderLine {
	private int quantity;
	private double subTotal;
	private Product product;
	public OrderLine(int quantity, double subTotal, Product product) {
		super();
		this.quantity = quantity;
		this.subTotal = subTotal;
		this.product = product;
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
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	
}
