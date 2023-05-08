package shop.Entity;

public class Category {
	private int id;
	private String nameCategory;
	private String description;
	private boolean status ;
	
	
	public Category() {
		super();
	}

	
	public Category(int id, String nameCategory, String description, boolean status) {
		super();
		this.id = id;
		this.nameCategory = nameCategory;
		this.description = description;
		this.status = status;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameCategory() {
		return nameCategory;
	}
	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
