package Model;

public class Equipment {

	private String type;
	private String description;
	private double rentPrice;
	
	public Equipment(String type, String description, double rentPrice) {
		super();
		this.type = type;
		this.description = description;
		this.rentPrice = rentPrice;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}

	public Equipment() {
		
	}
}
