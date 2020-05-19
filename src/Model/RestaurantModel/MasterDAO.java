package Model.RestaurantModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class MasterDAO {
	
	private Connection conn = null;
    private PreparedStatement pstmt = null;
    private Statement st = null;
    private ResultSet rs = null;

    //private String url="jdbc:mysql://117.17.113.248:3306/restaurant?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
    private String url="jdbc:mysql://27.96.134.5:3306/restaurant?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
    private String uid="hgf107103";
    private String upass="Hwt0147258!";
    
    private MasterDAO() {}
    
    public static MasterDAO getInstance() {
    	return new MasterDAO();
    }
    
    private final void cutConnect() {
    	try {
    		
			if (conn != null) conn.close();
			if (pstmt != null) pstmt.close();
			if (st != null) st.close();
			if (rs != null) rs.close();
			
		} catch (Exception e) {
			System.out.println("DB ���� ���� ����");
		}
    }
    
    public boolean addNewMenu(MenuVO mv) {
    	try {
    		String sql = "INSERT INTO menu (menuName, menuCost, categoryNumber) values ('" + mv.getMenuName() + "', " + mv.getMenuCost() + ", " + mv.getCategoryNumber() +")";
    		System.out.println(sql);
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("����̺� �����");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB ������");
            
            pstmt = conn.prepareStatement(sql);
            pstmt.execute();
            System.out.println("�޴� �߰� ���� ����");
            
            DBAutoIncrementSort();
            cutConnect();
			return true;
		} catch (Exception e) {
			System.out.println("�޴� �߰� DAO ���� �߻�");
			cutConnect();
			return false;
		}
    }
    
    public boolean addMenuNameCheck(String menuName) {
    	try {
    		String sql = "SELECT * FROM menu WHERE menuName = '" + menuName + "'";
    		System.out.println(sql);
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("����̺� �����");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB ������");
            
            st = conn.createStatement();
            System.out.println("������Ʈ��Ʈ ��ü ������");
            
            rs = st.executeQuery(sql);
            
            while (rs.next()) {
				if (rs.getString("menuName").equals(menuName)) {
					return false;
				}
			}
            
            cutConnect();
            return true;
            
		} catch (Exception e) {
			System.out.println("�޴� �߰� �̸�üũ DAO ���� �߻�");
			cutConnect();
			return false;
		}
    }
    
    public int checkCategory (String category) {
    	try {
    		String sql = "SELECT * FROM menucategory WHERE categoryName = '" + category + "'";
    		System.out.println(sql);
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("����̺� �����");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB ������");
            
            st = conn.createStatement();
            System.out.println("������Ʈ��Ʈ ��ü ������");
            
            int categoryNumber = 0;
            rs = st.executeQuery(sql);
            System.out.println("����Ʈ �� ��ü ������");
            
            while (rs.next()) {
				categoryNumber = rs.getInt("categoryNumber");
			}
            
            cutConnect();
            return categoryNumber;
            
		} catch (Exception e) {
			System.out.println("ī�װ� üũ DAO ���� �߻� : " + e);
			cutConnect();
			return -1;
		}
    }
    
    public boolean isMenuDataChanged(MenuVO mv) {
    	try {
    		String sql = "SELECT * FROM menu WHERE menuNumber = " + mv.getMenuNumber() + " AND menuName = '" + mv.getMenuName() +" ' AND menuCost = " + mv.getMenuCost() + " AND categoryNumber = " + mv.getCategoryNumber();
    		System.out.println(sql);
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("����̺� �����");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB ������");
            
            st = conn.createStatement();
            System.out.println("������Ʈ��Ʈ ��ü ������");
            
            rs = st.executeQuery(sql);
            
            while (rs.next()) {
            	System.out.println("�������� ����. return false");
            	return false;
			}
            System.out.println("����üũ��. return true");
			return true;
			
		} catch (Exception e) {
			cutConnect();
			System.out.println("�޴� ���� ������ �˻� DAO ���� �߻� : " + e);
			return false;
		}
    }
    
    public boolean updateMenu(MenuVO mv) {
    	try {
    		if (mv.getCategoryNumber() > 0) {
    			
    			String sql = "UPDATE menu SET menuName = '" + mv.getMenuName() + "', menuCost = " + mv.getMenuCost() + ", categoryNumber = " + mv.getCategoryNumber() + " WHERE menuNumber = " + mv.getMenuNumber();
        		System.out.println(sql);
        		
        		Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("����̺� �����");

                conn = DriverManager.getConnection(url, uid, upass);
                System.out.println("DB ������");
                
                pstmt = conn.prepareStatement(sql);
                pstmt.execute();
                System.out.println("�޴� �߰� ���� ����");
                
                DBAutoIncrementSort();
                cutConnect();
    			return true;
    			
			} else {
				cutConnect();
				System.out.println("�޴� ������Ʈ DAO ī�װ���ȣ ���� �߻�");
				return false;
			}
    		
		} catch (Exception e) {
			cutConnect();
			System.out.println("�޴� ������Ʈ DAO ���� �߻� : " + e);
			return false;
		}
    }
    
    public boolean deleteMenu(MenuVO mv) {
    	try {
    		
    		String sql = "DELETE FROM menu WHERE menuNumber = " + mv.getMenuNumber() + " AND menuName = '" + mv.getMenuName() +" ' AND menuCost = " + mv.getMenuCost() + " AND categoryNumber = " + mv.getCategoryNumber();
    		System.out.println(sql);
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("����̺� �����");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB ������");
            
            pstmt = conn.prepareStatement(sql);
            System.out.println("����������Ʈ��Ʈ ��ü ������");
            
            pstmt.execute();
            System.out.println("�޴� �߰� ���� ����");
            
            DBAutoIncrementSort();
            cutConnect();
            return true;
            
		} catch (Exception e) {
			
			cutConnect();
			System.out.println("�޴� �߰� ���� ���� �߻�");
			return false;
		}
    }
    
    public MenuVO showOneMenu(String name) {
    	try {
    		MenuVO mv = MenuVO.getInstence();
    		
    		String sql = "SELECT * FROM menu AS t1 LEFT JOIN menucategory AS t2 ON t1.categoryNumber = t2.categoryNumber WHERE menuName = '" + name + "'"; 
    		System.out.println(sql);
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("����̺� �����");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB ������");
            
            st = conn.createStatement();
            System.out.println("������Ʈ��Ʈ ��ü ������");
            
            rs = st.executeQuery(sql);
            System.out.println("����Ʈ ��ü ������");
            
            while (rs.next()) {
				mv.setMenuNumber(rs.getInt("menuNumber"));
				mv.setMenuName(rs.getString("menuName"));
				mv.setMenuCost(rs.getInt("menuCost"));
				mv.setCategoryNumber(rs.getInt("categoryNumber"));
				mv.setCategoryName(rs.getString("categoryName"));
			}
            System.out.println("menu VO �� �����");
            
            cutConnect();
            if (mv.getMenuName() != null) {
            	return mv;
			} else {
				return null;
			}
			
		} catch (Exception e) {
			System.out.println("�޴� ��� DAO ���� �߻� : " + e);
			cutConnect();
			return null;
		}
    }
    
    public ArrayList<MenuVO> showAllMenu(String order, String orderSort)	{
    	try {
    		ArrayList<MenuVO> list = new ArrayList<MenuVO>();
    		
    		String sql = "SELECT * FROM menu AS t1 LEFT JOIN menucategory AS t2 ON t1.categoryNumber = t2.categoryNumber ORDER BY " + order + " " + orderSort;
    		System.out.println(sql);
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("����̺� �����");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB ������");
            
            st = conn.createStatement();
            System.out.println("������Ʈ��Ʈ ��ü ������");
            
            rs = st.executeQuery(sql);
            System.out.println("����Ʈ ��ü ������");
            
            while (rs.next()) {
            	int menuNumber = rs.getInt("menuNumber");
            	String menuName = rs.getString("menuName");
            	int menuCost = rs.getInt("menuCost");
            	int categoryNumber = rs.getInt("categoryNumber");
            	String categoryName = rs.getString("categoryName");
            	MenuVO mv = MenuVO.getInstence(menuNumber, menuName, menuCost, categoryNumber, categoryName);
            	list.add(mv);
			}
            
            System.out.println(list.toString());
            cutConnect();
            
            return list;
			
			
		} catch (Exception e) {
			System.out.println("�޴� ��� DAO ���� �߻� : " + e);
			cutConnect();
			return null;
		}
    }
    
    //�����ͺ��̽��� ������ũ����Ʈ�� sort
    private void DBAutoIncrementSort() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("����̺� �����");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB ������");
            
			System.out.println("mysql : �����ͺ��̽� ���� ��ũ����Ʈ �簻�� ����");
			
			String sql1 = "ALTER TABLE menu AUTO_INCREMENT=1";
			String sql2 = "SET @COUNT = 0";
			String sql3 = "UPDATE menu SET menuNumber = @COUNT:=@COUNT+1";
			String sql4 = "ALTER TABLE menu AUTO_INCREMENT=@COUNT:=@COUNT+1";
			PreparedStatement pstmt = conn.prepareStatement(sql1);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql2);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql3);
			pstmt.executeUpdate();
			System.out.println("mysql : �޴� �����ͺ��̽� ���� ��ũ����Ʈ �簻�� �Ϸ�");
			
			
			
			sql1 = "ALTER TABLE mytable AUTO_INCREMENT=1";
			sql2 = "SET @COUNT = 0";
			sql3 = "UPDATE mytable SET tableNumber = @COUNT:=@COUNT+1";
			sql4 = "ALTER TABLE mytable AUTO_INCREMENT=7";
			pstmt = conn.prepareStatement(sql1);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql2);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql3);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql4);
			pstmt.executeUpdate();
			System.out.println("mysql : ���̺� �����ͺ��̽� ���� ��ũ����Ʈ �簻�� �Ϸ�");
			
			
			
			sql1 = "ALTER TABLE tableorder AUTO_INCREMENT=1";
			sql2 = "SET @COUNT = 0";
			sql3 = "UPDATE tableorder SET orderNumber = @COUNT:=@COUNT+1";
			pstmt = conn.prepareStatement(sql1);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql2);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql3);
			pstmt.executeUpdate();
			System.out.println("mysql : ���� �����ͺ��̽� ���� ��ũ����Ʈ �簻�� �Ϸ�");
			
			cutConnect();
			
		} catch (Exception e) {
			cutConnect();
			System.out.println("mysql : �����ͺ��̽� ���� ��ũ����Ʈ �簻�� �����߻�\n");
		}
		
	}
    
    
    //���� ���̺� ���� ������ ������ ������Ʈ �޼ҵ�
    
    public boolean addNewTable() {
    	try {
    		String sql = "INSERT INTO mytable () values ()";
    		System.out.println(sql);
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("����̺� �����");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB ������");
            
            pstmt = conn.prepareStatement(sql);
            pstmt.execute();
            System.out.println("���̺� �߰� ���� ����");
            
            DBAutoIncrementSort();
            cutConnect();
			return true;
			
		} catch (Exception e) {
			System.out.println("���̺� �߰� DAO ���� �߻�");
			cutConnect();
			return false;
		}
    }
    
    public boolean deleteTableCheck() {
    	try {
    		String sql = "SELECT * FROM mytable ORDER BY tableNumber DESC LIMIT 1";
    		System.out.println(sql);
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("����̺� �����");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB ������");
            
            st = conn.createStatement();
            System.out.println("������Ʈ��Ʈ ��ü ������");
            
            rs = st.executeQuery(sql);
            System.out.println("����Ʈ ��ü ������");
            
            while (rs.next()) {
            	if (rs.getString("customersId") != null) {
            		cutConnect();
					return false;
				}
			}
            
            cutConnect();
            return true;
            
		} catch (Exception e) {
			System.out.println("���̺� ���� üũ DAO ���� �߻� : " + e);
			cutConnect();
			return false;
		}
    }
    
    public boolean deleteTable() {
    	try {
    		boolean check = deleteTableCheck();
    		
    		if (check) {
				
    			String sql = "DELETE FROM mytable ORDER BY tableNumber DESC LIMIT 1";
        		System.out.println(sql);
        		
        		Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("����̺� �����");

                conn = DriverManager.getConnection(url, uid, upass);
                System.out.println("DB ������");
                
                pstmt = conn.prepareStatement(sql);
                pstmt.execute();
                System.out.println("���̺� ���� ���� ����");
                
                DBAutoIncrementSort();
    			cutConnect();
        		return true;
			} else {
				System.out.println("���̺� ���� DAO ���� �߻� : ������ ���̺� �մ� ����");
				cutConnect();
				return false;
			}
    		
		} catch (Exception e) {
			System.out.println("���̺� ���� DAO ���� �߻� : " + e);
			cutConnect();
			return false;
		}
    }
    
    public ArrayList<TableVO> showAllTable() {
    	try {
    		ArrayList<TableVO> list = new ArrayList<TableVO>();
    		
    		String sql = "SELECT t1.tableNumber, customersId, customersName, SUM((t2.orderCount - t2.orderDiscount) * t2.orderCost) AS costTotal FROM mytable AS t1 LEFT JOIN tableorder AS t2 ON t1.tableNumber = t2.tableNumber GROUP BY t1.tableNumber ORDER BY tableNumber ASC";
    		System.out.println(sql);
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("����̺� �����");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB ������");
            
            st = conn.createStatement();
            System.out.println("������Ʈ��Ʈ ��ü ������");
            
            rs = st.executeQuery(sql);
            System.out.println("����Ʈ ��ü ������");
            
            while (rs.next()) {
            	int tableNumber = rs.getInt("tableNumber");
            	
            	if (rs.getString("customersId") == null) {
					list.add(TableVO.getInstance(tableNumber, null, null, 0));
				} else {
					String customersId = rs.getString("customersId");
					String customersName = rs.getString("customersName");
					int costTotal = rs.getInt("costTotal");
					list.add(TableVO.getInstance(tableNumber, customersId, customersName, costTotal));
				}
			}
            
            for (TableVO tableVO : list) {
				System.out.println("���̺� �ѹ� : " + tableVO.getTableNumber());
				System.out.println("�� �̸� : " + tableVO.getCustomersName());
				System.out.println("�� ���̵� : " + tableVO.getCustomersId());
				System.out.println("���̺� �հ� : " + tableVO.getCostTotal());
			}
            cutConnect();
            return list;
			
			
		} catch (Exception e) {
			System.out.println("���̺� ����Ʈ DAO ���� �߻� : " + e);
			cutConnect();
			return null;
		}
    }
    
    public ArrayList<OrderVO> showOneTableOrderList(String myTableNumber) {
    	try {
    		
    		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
    		int count = 0;
    		
    		String sql = "SELECT *, (orderCount - orderDiscount) * orderCost AS orderTotal FROM tableorder WHERE tableNumber = " + myTableNumber;
    		System.out.println(sql);
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("����̺� �����");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB ������");
            
            st = conn.createStatement();
            System.out.println("������Ʈ��Ʈ ��ü ������");
            
            rs = st.executeQuery(sql);
            System.out.println("����Ʈ ��ü ������");
			
            while (rs.next()) {
            	count++;
            	int tableNumber = rs.getInt("tableNumber");
            	String orderName = rs.getString("orderName");
            	int orderCost = rs.getInt("orderCost");
            	int orderCount = rs.getInt("orderCount");
            	int orderDiscount = rs.getInt("orderDiscount");
            	int orderTotal = rs.getInt("orderTotal");
            	list.add(new OrderVO(tableNumber, orderName, orderCost, orderCount, orderDiscount, orderTotal));
            	System.out.println("���̺�ѹ� : " + tableNumber);
            	System.out.println(orderName);
            	System.out.println(orderCost);
            	System.out.println(orderCount);
            	System.out.println(orderDiscount);
            	System.out.println(orderTotal);
			}
            System.out.println("OrderVO ��ü ������");
            
            if (count > 0) {
            	System.out.println("OrderVO ��ü ���޵�");
            	cutConnect();
            	return list;
			} else {
				System.out.println("OrderVO ��ü ����Ʈ ����, null ���޵�");
				cutConnect();
				return null;
			}
            
            
		} catch (Exception e) {
			System.out.println("���̺� �󼼺��� DAO ���� �߻� : " + e);
			cutConnect();
			return null;
		}
    }
    
    public ArrayList<paymentHistoryVO> showAllPaymentHistory(String order, String orderSet){
    	try {
    		
    		ArrayList<paymentHistoryVO> list = new ArrayList<paymentHistoryVO>();
    		
    		String sql = "SELECT * FROM paymentHistory AS t1 LEFT JOIN (SELECT payNumber, SUM((orderCount - orderDiscount) * menuCost) AS payTotal FROM paymentDetails GROUP BY payNumber) AS t2 ON t1.payNumber = t2.payNumber ORDER BY " + order + " " + orderSet + ", HistoryNumber ASC";
    		System.out.println(sql);
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("����̺� �����");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB ������");
            
            st = conn.createStatement();
            System.out.println("������Ʈ��Ʈ ��ü ������");
            
            rs = st.executeQuery(sql);
            System.out.println("����Ʈ ��ü ������");
			
            while (rs.next()) {
            	Date payDate = rs.getDate("payDate");
            	int payNumber = rs.getInt("t1.payNumber");
            	int tableNumber = rs.getInt("tableNumber");
            	String customersName = rs.getString("customersName");
            	String customersId = rs.getString("customersId");
            	int payTotal = rs.getInt("payTotal");
            	System.out.println(payDate);
            	System.out.println(payNumber);
            	System.out.println(tableNumber);
            	System.out.println(customersName);
            	System.out.println(customersId);
            	System.out.println(payTotal);
            	paymentHistoryVO pvinct = new paymentHistoryVO(payDate, payNumber, tableNumber, customersName, customersId);
            	pvinct.setPayTotal(payTotal);
            	list.add(pvinct);
            	
			}
            System.out.println("paymentHistoryVO ��ü ������");
            
            cutConnect();
            return list;
			
            
            
		} catch (Exception e) {
			System.out.println("�������� �����丮 DAO ���� �߻� : " + e);
			cutConnect();
			return null;
		}
    }
    
    public ArrayList<paymentDetailVO> showPaymentDetail (int myPayNumber) {
try {
    		
    		ArrayList<paymentDetailVO> list = new ArrayList<paymentDetailVO>();
    		
    		String sql = "SELECT *, (orderCount - orderDiscount) * menuCost AS orderTotal FROM paymentDetails WHERE payNumber = " + myPayNumber;
    		System.out.println(sql);
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("����̺� �����");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB ������");
            
            st = conn.createStatement();
            System.out.println("������Ʈ��Ʈ ��ü ������");
            
            rs = st.executeQuery(sql);
            System.out.println("����Ʈ ��ü ������");
			
            while (rs.next()) {
            	int payNumber = rs.getInt("payNumber");
            	String menuName = rs.getString("menuName");
            	int menuCost = rs.getInt("menuCost");
            	int orderCount = rs.getInt("orderCount");
            	int orderDiscount = rs.getInt("orderDiscount");
            	int orderTotal = rs.getInt("orderTotal");
            	list.add(new paymentDetailVO(payNumber, menuName, menuCost, orderCount, orderDiscount, orderTotal));
			}
            System.out.println("paymentDetailVO ��ü ������");
            
            cutConnect();
            return list;
			
            
            
		} catch (Exception e) {
			System.out.println("�������� �󼼺��� DAO ���� �߻� : " + e);
			cutConnect();
			return null;
		}
    }
    	
    
}
