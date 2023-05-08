package shop.Entity;

import java.sql.Date;

public class BillDetail {
	private int id;
	private int productId ;
	private String productName;
	private int  bill_Id ;
	private Date transactionDate ;
	private int quantity;
	private double total;
	
	public BillDetail() {
		super();
	}
	
	public BillDetail(int id, int productId, String productName, int bill_Id, Date transactionDate, int quantity,
			double total) {
		super();
		this.id = id;
		this.productId = productId;
		this.productName = productName;
		this.bill_Id = bill_Id;
		this.transactionDate = transactionDate;
		this.quantity = quantity;
		this.total = total;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getBill_Id() {
		return bill_Id;
	}

	public void setBill_Id(int bill_Id) {
		this.bill_Id = bill_Id;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	
	
	
	
}
