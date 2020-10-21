package Model;

public class GunReplica extends Product {

	private static double purchasePrice;
	private static int minOnStock;
	private static Product productType;
	private String calibre;
	private String material;
	
	public GunReplica(String calibre, String material, String name, double purchasePrice, double salesPrice, String countryOfOrigin, int minOnStock,
			Product productType) {
		super(countryOfOrigin, salesPrice, salesPrice, countryOfOrigin, minOnStock, productType);
		this.calibre = calibre;
		this.material = material;
	}

	public String getCalibre() {
		return calibre;
	}

	public void setCalibre(String calibre) {
		this.calibre = calibre;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

}
