package Model.RestaurantModel;

public class paymentDetailVO {
	
	private int payNumber;
	private String menuName;
	private int menuCost;
	private int orderCount;
	private int orderDiscount;
	private int orderTotal;
	
	
	
	public paymentDetailVO(int payNumber, String menuName, int menuCost, int orderCount, int orderDiscount, int orderTotal) {
		this.payNumber = payNumber;
		this.menuName = menuName;
		this.menuCost = menuCost;
		this.orderCount = orderCount;
		this.orderDiscount = orderDiscount;
		this.orderTotal = orderTotal;
	}
	
	public int getPayNumber() {
		return payNumber;
	}
	public void setPayNumber(int payNumber) {
		this.payNumber = payNumber;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getMenuCost() {
		return menuCost;
	}
	public void setMenuCost(int menuCost) {
		this.menuCost = menuCost;
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
