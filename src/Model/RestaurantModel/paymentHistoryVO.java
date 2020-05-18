package Model.RestaurantModel;

import java.util.Date;

public class paymentHistoryVO {
	
	private Date payDate;
	private int payNumber;
	private int tableNumber;
	private String customersName;
	private String customersId;
	private int payTotal;
	
	private paymentHistoryVO(Date payDate, int payNumber, int tableNumber, String customersName, String customersId) {
		this.payDate = payDate;
		this.payNumber = payNumber;
		this.tableNumber = tableNumber;
		this.customersName = customersName;
		this.customersId = customersId;
	}
	
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public int getPayNumber() {
		return payNumber;
	}
	public void setPayNumber(int payNumber) {
		this.payNumber = payNumber;
	}
	public int getTableNumber() {
		return tableNumber;
	}
	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}
	public String getCustomersName() {
		return customersName;
	}
	public void setCustomersName(String customersName) {
		this.customersName = customersName;
	}
	public String getCustomersId() {
		return customersId;
	}
	public void setCustomersId(String customersId) {
		this.customersId = customersId;
	}

	public int getPayTotal() {
		return payTotal;
	}

	public void setPayTotal(int payTotal) {
		this.payTotal = payTotal;
	}
	
	
}
