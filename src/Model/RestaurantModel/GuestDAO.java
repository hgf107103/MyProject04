package Model.RestaurantModel;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Model.UserModel.UserVO;

public class GuestDAO {
	
	private Connection conn = null;
    private PreparedStatement pstmt = null;
    private Statement st = null;
    private ResultSet rs = null;

    //private String url="jdbc:mysql://117.17.113.248:3306/restaurant?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
    private static final String url="jdbc:mysql://27.96.134.5:3306/restaurant?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
    private static final String uid="hgf107103";
    private static final String upass="Hwt0147258!";
    
    private GuestDAO() {}
    
    public static GuestDAO getInstance(){
    	return new GuestDAO();
    }
    
    public TableVO getGuestTable(String id) {
    	try {
    		TableVO tv = null;
    		
    		String sql = "SELECT t1.tableNumber, customersId, customersName, SUM((t2.orderCount - t2.orderDiscount) * t2.orderCost) AS costTotal FROM mytable AS t1 LEFT JOIN tableorder AS t2 ON t1.tableNumber = t2.tableNumber WHERE customersId = '" + id +"' GROUP BY t1.tableNumber ORDER BY tableNumber ASC";
    		System.out.println(sql);
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("����̺� �����");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB ������");
            
            st = conn.createStatement();
            System.out.println("������Ʈ��Ʈ ��ü ������");
            
            rs = st.executeQuery(sql);
            while (rs.next()) {
            	int tableNumber = rs.getInt("tableNumber");
            	String customersId = rs.getString("customersId");
            	String customersName = rs.getString("customersName");
            	int costTotal = rs.getInt("costTotal");
            	
				tv = TableVO.getInstance(tableNumber, customersId, customersName, costTotal);
			}
            
			cutConnect();
            return tv;
            
		} catch (Exception e) {
			System.out.println("�Խ�Ʈ ���̺� �ҷ����� DAO ���� �߻�");
			cutConnect();
			return null;
		}
    }
    
    public ArrayList<TableVO> getDisableTableList() {
    	try {
    		ArrayList<TableVO> list = new ArrayList<TableVO>();
    		
    		String sql = "SELECT * FROM mytable ORDER BY tableNumber ASC";
    		System.out.println(sql);
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("����̺� �����");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB ������");
            
            st = conn.createStatement();
            System.out.println("������Ʈ��Ʈ ��ü ������");
            
            rs = st.executeQuery(sql);
            while (rs.next()) {
            	int tableNumber = rs.getInt("tableNumber");
            	String customersId = rs.getString("customersId");
            	String customersName = rs.getString("customersName");
            	list.add(new TableVO(tableNumber, customersId, customersName));
            	System.out.println(tableNumber + " : " + customersId);
			}
            
            System.out.println("��ü ���̺� �ҷ����� DAO �Ϸ�");
			cutConnect();
            return list;
            
		} catch (Exception e) {
			
			System.out.println("��ü ���̺� �ҷ����� DAO ���� �߻�");
			cutConnect();
			return null;
		}
    }
    
    public boolean selectTable(UserVO uv, String tableNumber) {
    	try {
			String sql = "UPDATE mytable SET customersId = '" + uv.getId() + "', customersName = '" + uv.getName() + "' WHERE tableNumber = " + tableNumber;
			System.out.println(sql);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("����̺� �����");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB ������");
            
            pstmt = conn.prepareStatement(sql);
            pstmt.execute();
            System.out.println("���̺� ���� DAO �Ϸ� : " + tableNumber + " " + uv.getId());
            
			cutConnect();
			return true;
			
    	} catch (Exception e) {
    		System.out.println("���̺� ���� DAO ���� �߻�");
			cutConnect();
			return false;
		}
    }
    
    public boolean checkTable(String id) {
    	try {
    		String sql = "SELECT * FROM mytable WHERE customersId = '" + id + "' LIMIT 1";
    		System.out.println(sql);
    		
    		boolean check = true;
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("����̺� �����");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB ������");
            
            st = conn.createStatement();
            System.out.println("������Ʈ��Ʈ ��ü ������");
            
            rs = st.executeQuery(sql);
            while (rs.next()) {
            	check = false;
			}
            
            System.out.println("���̺� ���� üũ DAO �Ϸ� : " + check);
			cutConnect();
			
			return check;
			
		} catch (Exception e) {
			System.out.println("���̺� ���� üũ DAO ���� �߻�");
			cutConnect();
			return false;
		}
    }
    
    public boolean tableOut(String tableNumber) {
    	try {
			String sql = "UPDATE mytable SET customersId = null, customersName = null WHERE tableNumber = " + tableNumber;
			System.out.println(sql);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("����̺� �����");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB ������");
            
            pstmt = conn.prepareStatement(sql);
            pstmt.execute();
            System.out.println("���̺� ��� DAO �Ϸ� : " + tableNumber);
            
			cutConnect();
			return true;
			
    	} catch (Exception e) {
    		System.out.println("���̺� ��� DAO ���� �߻�");
			cutConnect();
			return false;
		}
    }
    
    public boolean checkNowOrder(String tableNumber) {
    	try {
    		String sql = "SELECT * FROM tableorder WHERE tableNumber = " + tableNumber;
    		System.out.println(sql);
    		
    		boolean check = true;
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("����̺� �����");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB ������");
            
            st = conn.createStatement();
            System.out.println("������Ʈ��Ʈ ��ü ������");
            
            rs = st.executeQuery(sql);
            while (rs.next()) {
            	check = false;
			}
            
            System.out.println("���̺� ��� �� üũ DAO �Ϸ� : " + check);
			cutConnect();
			
			return check;
			
		} catch (Exception e) {
			System.out.println("���̺� ��� �� üũ DAO ���� �߻�");
			cutConnect();
			return false;
		}
    }
    
    public ArrayList<OrderVO> getTableAllOrder(String myTableNumber) {
    	try {
    		System.out.println("getTableAllOrder ����");
    		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
    		
    		String sql = "SELECT *, (orderCount - orderDiscount)*orderCost AS orderTotal FROM tableorder WHERE tableNumber = " + myTableNumber;
    		System.out.println(sql);
    		
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("����̺� �����");
			
			conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB ������");
            
            st = conn.createStatement();
            System.out.println("������Ʈ��Ʈ ��ü ������");
    
            rs = st.executeQuery(sql);
            while (rs.next()) {
            	int tableNumber = rs.getInt("tableNumber");
            	String orderName = rs.getString("orderName");
            	int orderCost = rs.getInt("orderCost");
            	int orderCount = rs.getInt("orderCount");
            	int orderDiscount = rs.getInt("orderDiscount");
            	int orderTotal = rs.getInt("orderTotal");
            	list.add(new OrderVO(tableNumber, orderName, orderCost, orderCount, orderDiscount, orderTotal));
			}
            
            System.out.println("���̺� ���� ����Ʈ ��ȯ DAO �Ϸ�");
			cutConnect();
			return list;
			
		} catch (Exception e) {
			System.out.println("���̺� ���� ����Ʈ DAO ���� �߻�");
			cutConnect();
			return null;
		}
    }
    
    public boolean CompletePayment(String tableNumber) {
    		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("����̺� �����");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB ������");
            
            
			String sql = "DELETE FROM tableorder WHERE tableNumber = " + tableNumber;
			
			pstmt = conn.prepareStatement(sql);
			
			boolean check = pstmt.execute();
	        
			System.out.println("�ֹ����� ���� ����� : " + check);
			
            System.out.println("�ֹ����� ���� DAO �Ϸ�");
            
			cutConnect();
			return check;
		} catch (Exception e) {
			System.out.println("�ֹ����� ���� DAO ���� �߻�");
			cutConnect();
			return false;
		}
    }
    public boolean SaveGuestPaymentHistory(paymentHistoryVO ph) {
    	try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("����̺� �����");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB ������");
            
            
			String sql = "INSERT INTO paymentHistory (payDate, payNumber, tableNumber, customersName, customersId) VALUES (?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
			
			pstmt.setString(1, simple.format(ph.getPayDate()));
			pstmt.setInt(2, ph.getPayNumber());
			pstmt.setInt(3, ph.getTableNumber());
			pstmt.setString(4, ph.getCustomersName());
			pstmt.setString(5, ph.getCustomersId());
			
			boolean check = pstmt.execute();
	        
			System.out.println("�������� �����丮 ���� ����� : " + check);
			
            System.out.println("�������� �����丮 ���� DAO �Ϸ�");
            
			cutConnect();
			return check;
		} catch (Exception e) {
			System.out.println("�������� �����丮 ���� DAO ���� �߻�");
			cutConnect();
			return false;
		}
    }
    
    public boolean SaveGuestPaymentDetail(ArrayList<paymentDetailVO> list) {
    	try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("����̺� �����");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB ������");
            
            for (paymentDetailVO pv : list) {
				String sql = "INSERT INTO paymentDetails (payNumber, menuName, menuCost, orderCount, orderDiscount) VALUES (?,?,?,?,?)";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, pv.getPayNumber());
				pstmt.setString(2, pv.getMenuName());
				pstmt.setInt(3, pv.getMenuCost());
				pstmt.setInt(4, pv.getOrderCount());
				pstmt.setInt(5, pv.getOrderDiscount());
				
	            boolean check = pstmt.execute();
	            
	            System.out.println("�������� ������ ���� ����� : " + check);
			}
            System.out.println("�������� ������ ���� DAO �Ϸ�");
            
			cutConnect();
			return true;
		} catch (Exception e) {
			System.out.println("�������� ������ ���� DAO ���� �߻�");
			cutConnect();
			return false;
		}
    }
	
	private void DBAutoIncrementSort() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("����̺� �����");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB ������");
            
			System.out.println("mysql : �����ͺ��̽� ���� ��ũ����Ʈ �簻�� ����");
			
			String sql1 = "ALTER TABLE mytable AUTO_INCREMENT=1";
			String sql2 = "SET @COUNT = 0";
			String sql3 = "UPDATE mytable SET tableNumber = @COUNT:=@COUNT+1";
			String sql4 = "ALTER TABLE mytable AUTO_INCREMENT=7";
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
	
}
