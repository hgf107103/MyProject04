package Model.RestaurantModel;

public class MenuVO {
	private int menuNumber; //�޴���ȣ
	private String menuName; //�޴��̸�
	private int menuCost; //�޴�����
	
	private MenuVO(int menuNumber, String menuName, int menuCost) {
		this.menuNumber = menuNumber;
		this.menuName = menuName;
		this.menuCost = menuCost;
	}
	
	public static MenuVO getInstence(int menuNumber, String menuName, int menuCost) {
		return new MenuVO(menuNumber, menuName, menuCost);
	} //�޴��ѹ� ���� ����
	
	public static MenuVO getInstence(String menuName, int menuCost) {
		return new MenuVO(0, menuName, menuCost);
	} //�޴��ѹ��� �ʿ���� ��� (���޴� ��)
	
	public int getMenuNumber() {
		return menuNumber;
	}
	public void setMenuNumber(int menuNumber) {
		this.menuNumber = menuNumber;
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
	
	
}
