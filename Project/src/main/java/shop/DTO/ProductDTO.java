package shop.DTO;

import shop.Entity.Category;

public class ProductDTO {
	
	private int id;
	private String productName;
	private String productContent;
	private String description;
	private double price;
	private String image;
	private int quantity;
	private int category_Id;
	public String categoryName;
	public Category Category;
	private boolean status;
	
	
	public ProductDTO() {
		super();
	}
	
	
	
	public ProductDTO(shop.Entity.Category category) {
		super();
		Category = category;
	}



	public ProductDTO(int id, String productName, String productContent, String description, double price, String image,
			int quantity, int category_Id, String categoryName, shop.Entity.Category category, boolean status) {
		super();
		this.id = id;
		this.productName = productName;
		this.productContent = productContent;
		this.description = description;
		this.price = price;
		this.image = image;
		this.quantity = quantity;
		this.category_Id = category_Id;
		this.categoryName = categoryName;
		Category = category;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductContent() {
		return productContent;
	}
	public void setProductContent(String productContent) {
		this.productContent = productContent;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCategory_Id() {
		return category_Id;
	}
	public void setCategory_Id(int category_Id) {
		this.category_Id = category_Id;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}



	public Category getCategory() {
		return Category;
	}



	public void setCategory(Category category) {
		Category = category;
	}
	
	
	
}
