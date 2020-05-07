package Model.RestaurantModel;

public class MenuVO {
	private int menuNumber; //메뉴번호
	private String menuName; //메뉴이름
	private int menuCost; //메뉴가격
	
	private MenuVO(int menuNumber, String menuName, int menuCost) {
		this.menuNumber = menuNumber;
		this.menuName = menuName;
		this.menuCost = menuCost;
	}
	
	public static MenuVO getInstence(int menuNumber, String menuName, int menuCost) {
		return new MenuVO(menuNumber, menuName, menuCost);
	} //메뉴넘버 붙은 버전
	
	public static MenuVO getInstence(String menuName, int menuCost) {
		return new MenuVO(0, menuName, menuCost);
	} //메뉴넘버가 필요없는 경우 (새메뉴 등)
	
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
