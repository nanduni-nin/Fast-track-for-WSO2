package org.wso2.carbon.order.mgt.data;

public class Item {
	private long itemId;
	private String name;
	private double price;
	private String description;

	public Item(long itemId, String name, double price, String description) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public long getItemId() {
		return itemId;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
	public String getDescription(){
		return description;
	}
}
