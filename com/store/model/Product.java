package com.store.model;

public class Product {

	// declaring instances
	private String itemCode;
	private String itemName;
	private double buyingPrice;
	private double sellingPrice;
	private Category category;
	private double tax;
	private int quantity;

	// default constructor
	public Product() {
	}

	// overloaded constructors
	public Product(String productCode) {
		this.itemCode = productCode;
	}

	public Product(String itemCode, String itemName, double buyingPrice,
			double sellingPrice, Category category, double tax, int quantity) {
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.buyingPrice = buyingPrice;
		this.sellingPrice = sellingPrice;
		this.category = category;
		this.tax = tax;
		this.quantity = quantity;
	}

	public String getItemCode() {
		return itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public double getBuyingPrice() {
		return buyingPrice;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public Category getCategory() {
		return category;
	}

	public double getTax() {
		return tax;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Product) {
			Product product = (Product) obj;
			return product.itemCode.equals(itemCode);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Product [Item Code: " + itemCode + " | Name: " + itemName
				+ " | Buying Price: " + buyingPrice + " | Selling Price: "
				+ sellingPrice + " | Category: " + category + " | Tax: " + tax
				+ " | Quantity: " + quantity + "]";
	}

}
