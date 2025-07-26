package model.entities;

public class Product implements Comparable<Product> {
	private String name;
	private int quantity;
	private Double price;
	
	public Product(String name, int quantity, Double price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int compareTo(Product other) {
		return name.compareTo(other.getName());
		
	}
	@Override
	public String toString() {
		return name + " - " 
					+ String.format("R$ %.2f", price) 
					+ " - Quantity: " + quantity 
					+ " - Value Total: " 
					+ String.format("R$ %.2f", totalValue());
	}
	
	public Double totalValue() {
		return price * quantity;
	}
	
	public void addStock(int quantity) {
		this.quantity += quantity;
	}
	
}
