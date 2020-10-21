package Model;

public class Invoice {

	private int invoiceNo;
	private String paymentDate;
	private int amount;
	
	public Invoice(int invoiceNo, String paymentDate, int amount) {
		super();
		this.invoiceNo = invoiceNo;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}

	public int getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Invoice() {
		
	}
}
