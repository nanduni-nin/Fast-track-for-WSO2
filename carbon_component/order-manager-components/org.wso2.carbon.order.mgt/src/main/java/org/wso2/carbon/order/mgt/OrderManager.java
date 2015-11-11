package org.wso2.carbon.order.mgt;
/**
 * This class represents the order managers service. It creates 
 * Several orders and provides the getItems() method to others to
 * interact with the service. 
 */
import java.util.ArrayList;
import java.util.List;

import org.wso2.carbon.order.mgt.data.Item;

public class OrderManager {

	private List<Item> items;

	public OrderManager() {
		items = new ArrayList<Item>();
		initItems(items);
	}

	private void initItems(List<Item> item) {
		Item i1 = new Item(1, "Java Book", 23.23,"This is a good");
		Item i2 = new Item(2, "Hello Java", 124.23, "awesome!");
		Item i3 = new Item(3, "Data Analysis in Python", 122.23, "awesome!");
		Item i4 = new Item(4, "Getting Started: Data Sciece", 1222.23, "awesome!");
		Item i5 = new Item(5, "Effective Java", 112.23, "awesome!");
		Item i6 = new Item(6, "!(Just Data)", 122.23, "good book to have!");
		item.add(i1);
		item.add(i2);
		item.add(i3);
		item.add(i4);
		item.add(i5);
		item.add(i6);
	}
	
	
    /***
     * Clinets will use this method to access the details about oders
     */
	public Item[] getItems() {
		return items.toArray(new Item[items.size()]);
	}
}
