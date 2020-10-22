package Model;

//
public class Product {
	private String name;
	private double purchasePrice;
	private Double salesPrice;
	private String countryOfOrigin;
	private Integer minOnStock;
	private int productId;

	public Product(int productId, String name, double purchasePrice, Double salesPrice, String countryOfOrigin,
			Integer minOnStock) {
		this.name = name;
		this.purchasePrice = purchasePrice;
		this.salesPrice = salesPrice;
		this.countryOfOrigin = countryOfOrigin;
		this.minOnStock = minOnStock;
		this.productId = productId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public void setSalesPrice(Double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public void setMinOnStock(Integer minOnStock) {
		this.minOnStock = minOnStock;
	}

	public String getName() {
		return name;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public Double getSalesPrice() {
		return salesPrice;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public Integer getMinOnStock() {
		return minOnStock;
	}

	public int getProductId() {
		return productId;
	}
	

}
