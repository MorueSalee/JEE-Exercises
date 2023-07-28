package fr.eni.ecole.bo;

public class Sweet {

	private Integer id;

	private String name;

	private String description;

	private String taste;

	private Float price;

	private Integer quantity;
	
	public Sweet() {
		super();
	}

	public Sweet(Integer id, String name, String description, String taste, Float price, Integer quantity) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.taste = taste;
		this.price = price;
		this.quantity = quantity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTaste() {
		return taste;
	}

	public void setTaste(String taste) {
		this.taste = taste;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
