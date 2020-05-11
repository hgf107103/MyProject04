package Model.RestaurantModel;

public class MenuVO {
	private int menuNumber; //�޴���ȣ
	private String menuName; //�޴��̸�
	private int menuCost; //�޴�����
	private int categoryNumber; //�޴�����
	private String categoryName;
	
	private MenuVO(int menuNumber, String menuName, int menuCost, int categoryNumber) {
		this.menuNumber = menuNumber;
		this.menuName = menuName;
		this.menuCost = menuCost;
		this.categoryNumber = categoryNumber;
	}
	
	public static MenuVO getInstence(int menuNumber, String menuName, int menuCost, int categoryNumber) {
		return new MenuVO(menuNumber, menuName, menuCost, categoryNumber);
	} //�޴��ѹ� ���� ����
	
	public static MenuVO getInstence(String menuName, int menuCost, int categoryNumber) {
		return new MenuVO(0, menuName, menuCost, categoryNumber);
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
	public int getCategoryNumber() {
		return categoryNumber;
	}
	public void setCategoryNumber(int categoryNumber) {
		this.categoryNumber = categoryNumber;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
