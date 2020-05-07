package Model.RestaurantModel;

import java.util.ArrayList;

public class TableVO {
	private int tableNumber;
	private String customers;
	private int costTotal;
	private int ownerCall;
	
	
	private TableVO (int tableNumber, String customers, int costTotal, int ownerCall) {
		setTableNumber(tableNumber);
		setCustomers(customers);
		setCostTotal(costTotal);
		setOwnerCall(ownerCall);
	}
	
	public TableVO getInstance(int tableNumber, String customers, int costTotal, int ownerCall) {
		return new TableVO(tableNumber, customers, costTotal, ownerCall);
	}
	
	public int getTableNumber() {
		return tableNumber;
	}
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	public String getCustomers() {
		return customers;
	}
	public void setCustomers(String customers) {
		this.customers = customers;
	}
	public int getCostTotal() {
		return costTotal;
	}
	public void setCostTotal(int costTotal) {
		this.costTotal = costTotal;
	}
	public int getOwnerCall() {
		return ownerCall;
	}
	public void setOwnerCall(int ownerCall) {
		this.ownerCall = ownerCall;
	}
	
	
	
}
