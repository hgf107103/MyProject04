package Model.RestaurantModel;

public class OrderVO {
	
	private int tableNumber;
	private String orderName;
	private int orderCost;
	private int orderCount;
	private int orderDiscount;
	private int orderTotal;
	
	
	
	public OrderVO(int tableNumber, String orderName, int orderCost, int orderCount, int orderDiscount, int orderTotal) {
		this.tableNumber = tableNumber;
		this.orderName = orderName;
		this.orderCost = orderCost;
		this.orderCount = orderCount;
		this.orderDiscount = orderDiscount;
		this.orderTotal = orderTotal;
	}
	
	public OrderVO(String orderName, int orderCount, int orderDiscount) {
		this.orderName = orderName;
		this.orderCount = orderCount;
		this.orderDiscount = orderDiscount;
	}
	
	public int getTableNumber() {
		return tableNumber;
	}
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public int getOrderCost() {
		return orderCost;
	}
	public void setOrderCost(int orderCost) {
		this.orderCost = orderCost;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public int getOrderDiscount() {
		return orderDiscount;
	}
	public void setOrderDiscount(int orderDiscount) {
		this.orderDiscount = orderDiscount;
	}
	public int getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}
}
