package Model.RestaurantModel;

import java.util.ArrayList;

public class TableVO {
	private int tableNumber;
	private String customersId;
	private String customersName;
	private int costTotal;
	
	
	public TableVO(int tableNumber, String customersId, String customersName) {
		this.tableNumber = tableNumber;
		this.customersId = customersId;
		this.customersName = customersName;
	}
	
	private TableVO(int tableNumber, String customersId, String customersName, int costTotal) {
		this.tableNumber = tableNumber;
		this.customersId = customersId;
		this.customersName = customersName;
		this.costTotal = costTotal;
	}
	
	public static TableVO getInstance(int tableNumber, String customersId, String customersName, int costTotal) {
		return new TableVO(tableNumber, customersId, customersName, costTotal);
	}
	
	public int getTableNumber() {
		return tableNumber;
	}
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	public String getCustomersId() {
		return customersId;
	}
	public void setCustomersId(String customersId) {
		this.customersId = customersId;
	}
	public String getCustomersName() {
		return customersName;
	}
	public void setCustomersName(String customersName) {
		this.customersName = customersName;
	}
	public int getCostTotal() {
		return costTotal;
	}
	public void setCostTotal(int costTotal) {
		this.costTotal = costTotal;
	}
	
	
	
}
