package shop.Entity;

public class Admin {
	private int id;
	private String adminName;
	private String password;
	private String email;
	private String address;
	private String phone;
	private boolean status;
	public Admin() {
		super();
	}
	public Admin(int id, String adminName, String password, String email, String address, String phone,
			boolean status) {
		super();
		this.id = id;
		this.adminName = adminName;
		this.password = password;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
