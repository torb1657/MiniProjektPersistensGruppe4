package Model;
//
public class Product {
	private String name;
	private double purchasePrice;
	private double salesPrice;
	private String countryOfOrigin;
	private int minOnStock;
	private int productId;
	
public Product(String name, double purchasePrice, double salesPrice, String countryOfOrigin, int minOnStock, int productId) {
		this.name = name;
		this.purchasePrice = purchasePrice;
		this.salesPrice = salesPrice;
		this.countryOfOrigin = countryOfOrigin;
		this.minOnStock = minOnStock;
		this.productId = productId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getPurchasePrice() {
	return purchasePrice;
}

public void setPurchasePrice(double purchasePrice) {
	this.purchasePrice = purchasePrice;
}

public double getSalesPrice() {
	return salesPrice;
}

public void setSalesPrice(double salesPrice) {
	this.salesPrice = salesPrice;
}

public String getCountryOfOrigin() {
	return countryOfOrigin;
}

public void setCountryOfOrigin(String countryOfOrigin) {
	this.countryOfOrigin = countryOfOrigin;
}

public int getMinOnStock() {
	return minOnStock;
}

public void setMinOnStock(int minOnStock) {
	this.minOnStock = minOnStock;
}


}

