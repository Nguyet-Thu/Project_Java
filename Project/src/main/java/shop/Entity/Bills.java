package shop.Entity;

public class Bills {
	private int id; 
	private String fullName ;
	private String phone ;
	private String email ;
	private String address ;
	private double total;
	private int quantity; 
	private String note ;
	private boolean status ; 
	
	
	public Bills() {
		super();
	}
	
	public Bills(int id, String fullName, String phone, String email, String address, double total, int quantity,
			String note, boolean status) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.total = total;
		this.quantity = quantity;
		this.note = note;
		this.status = status;
	}
	

	public int getId() {
		return id;
	}
	

	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
