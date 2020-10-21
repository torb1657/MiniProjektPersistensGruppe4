package Model;

public class Clothing extends Product {

	private String size;
	private String colour;
	private String brand;

	public Clothing(String size, String colour, String brand, String name, double purchasePrice, double salesPrice, String countryOfOrigin, int minOnStock,
			Product productType) {
		super(countryOfOrigin, salesPrice, salesPrice, countryOfOrigin, minOnStock, productType);
		this.size = size;
		this.colour = colour;
		this.brand = brand;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
}
