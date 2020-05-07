package Model.RestaurantModel;

public class OrderVO {
	
	private int tableNumber; // �ֹ��� ���̺��� �ѹ�
	private int orderNumber; // �ֹ��� �޴��� �޴��ѹ�
	private String orderName; // �ֹ��� �޴��� �̸�
	private int orderCost; //�ֹ��� �޴��� ����
	private int orderCount; // �ֹ��� �޴��� ����
	private int orderTotal; // �ֹ��� �޴��� �� ����
	
	private OrderVO(int tableNumber, int orderNumber, String orderName, int orderCost, int orderCount, int orderTotal) {
		this.tableNumber = tableNumber;
		this.orderNumber = orderNumber;
		this.orderName = orderName;
		this.orderCost = orderCost;
		this.orderCount = orderCount;
		this.orderTotal = orderTotal;
	}
	
	public OrderVO getInstance(int tableNumber, int orderNumber, String orderName, int orderCost, int orderCount, int orderTotal) {
		return new OrderVO(tableNumber, orderNumber, orderName, orderCost, orderCount, orderTotal);
	}
	
	public int getTableNumber() {
		return tableNumber;
	}
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
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
	public int getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(int orderTotal) {
		this.orderTotal = orderTotal;
	}
	
	
	
	
	
}
