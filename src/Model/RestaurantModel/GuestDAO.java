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
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            st = conn.createStatement();
            System.out.println("스테이트먼트 객체 생성됨");
            
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
			System.out.println("게스트 테이블 불러오기 DAO 오류 발생");
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
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            st = conn.createStatement();
            System.out.println("스테이트먼트 객체 생성됨");
            
            rs = st.executeQuery(sql);
            while (rs.next()) {
            	int tableNumber = rs.getInt("tableNumber");
            	String customersId = rs.getString("customersId");
            	String customersName = rs.getString("customersName");
            	list.add(new TableVO(tableNumber, customersId, customersName));
            	System.out.println(tableNumber + " : " + customersId);
			}
            
            System.out.println("전체 테이블 불러오기 DAO 완료");
			cutConnect();
            return list;
            
		} catch (Exception e) {
			
			System.out.println("전체 테이블 불러오기 DAO 오류 발생");
			cutConnect();
			return null;
		}
    }
    
    public boolean selectTable(UserVO uv, String tableNumber) {
    	try {
			String sql = "UPDATE mytable SET customersId = '" + uv.getId() + "', customersName = '" + uv.getName() + "' WHERE tableNumber = " + tableNumber;
			System.out.println(sql);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            pstmt = conn.prepareStatement(sql);
            pstmt.execute();
            System.out.println("테이블 착석 DAO 완료 : " + tableNumber + " " + uv.getId());
            
			cutConnect();
			return true;
			
    	} catch (Exception e) {
    		System.out.println("테이블 착석 DAO 오류 발생");
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
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            st = conn.createStatement();
            System.out.println("스테이트먼트 객체 생성됨");
            
            rs = st.executeQuery(sql);
            while (rs.next()) {
            	check = false;
			}
            
            System.out.println("테이블 착석 체크 DAO 완료 : " + check);
			cutConnect();
			
			return check;
			
		} catch (Exception e) {
			System.out.println("테이블 착석 체크 DAO 오류 발생");
			cutConnect();
			return false;
		}
    }
    
    public boolean tableOut(String tableNumber) {
    	try {
			String sql = "UPDATE mytable SET customersId = null, customersName = null WHERE tableNumber = " + tableNumber;
			System.out.println(sql);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            pstmt = conn.prepareStatement(sql);
            pstmt.execute();
            System.out.println("테이블 퇴실 DAO 완료 : " + tableNumber);
            
			cutConnect();
			return true;
			
    	} catch (Exception e) {
    		System.out.println("테이블 퇴실 DAO 오류 발생");
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
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            st = conn.createStatement();
            System.out.println("스테이트먼트 객체 생성됨");
            
            rs = st.executeQuery(sql);
            while (rs.next()) {
            	check = false;
			}
            
            System.out.println("테이블 퇴실 전 체크 DAO 완료 : " + check);
			cutConnect();
			
			return check;
			
		} catch (Exception e) {
			System.out.println("테이블 퇴실 전 체크 DAO 오류 발생");
			cutConnect();
			return false;
		}
    }
    
    public ArrayList<OrderVO> getTableAllOrder(String myTableNumber) {
    	try {
    		System.out.println("getTableAllOrder 시작");
    		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
    		
    		String sql = "SELECT *, (orderCount - orderDiscount)*orderCost AS orderTotal FROM tableorder WHERE tableNumber = " + myTableNumber;
    		System.out.println(sql);
    		
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이브 적재됨");
			
			conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            st = conn.createStatement();
            System.out.println("스테이트먼트 객체 생성됨");
    
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
            
            System.out.println("테이블 오더 리스트 반환 DAO 완료");
			cutConnect();
			return list;
			
		} catch (Exception e) {
			System.out.println("테이블 오더 리스트 DAO 오류 발생");
			cutConnect();
			return null;
		}
    }
    
    public boolean CompletePayment(String tableNumber) {
    		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            
			String sql = "DELETE FROM tableorder WHERE tableNumber = " + tableNumber;
			
			pstmt = conn.prepareStatement(sql);
			pstmt.execute();
	        
			System.out.println("주문내역 삭제 실행됨");
            System.out.println("주문내역 삭제 DAO 완료");
            
			cutConnect();
			return true;
		} catch (Exception e) {
			System.out.println("주문내역 삭제 DAO 오류 발생");
			cutConnect();
			return false;
		}
    }
    
    public int getTodayPayNumber() {
    	try {
    		
    		int result = 0;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = new java.util.Date();
            
			String sql = "SELECT COUNT(*) + 1 AS count FROM paymentHistory WHERE payDate = '" + sf.format(date) + "' LIMIT 1";
			System.out.println(sql);
			st = conn.createStatement();
			
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				result = rs.getInt("count");
			}
			
			SimpleDateFormat resultFormat = new SimpleDateFormat("yyyyMMdd");

            String answer = resultFormat.format(date) + result;
			
            System.out.println("주문번호 조회 DAO 완료 : " +	answer);
            
            
			cutConnect();
			return Integer.parseInt(answer);
			
		} catch (Exception e) {
			System.out.println("주문번호 조회 DAO 오류 발생");
			cutConnect();
			return 0;
		}
    }
   
    //디테일리스트를 불러오는 메소드
    public ArrayList<paymentDetailVO> GetPaymentDetailList (String tableNumber, int payNumber) {
    	try {
    		
    		ArrayList<paymentDetailVO> list = new ArrayList<paymentDetailVO>();
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
			String sql = "SELECT *, (orderCount - orderDiscount) * orderCost AS orderTotal FROM tableorder WHERE tableNumber = " + tableNumber;
			System.out.println(sql);
			
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				String menuName = rs.getString("orderName");
				int menuCost = rs.getInt("orderCost");
				int orderCount = rs.getInt("orderCount");
				int orderDiscount = rs.getInt("orderDiscount");
				int orderTotal = rs.getInt("orderTotal");
				
				list.add(new paymentDetailVO(payNumber, menuName, menuCost, orderCount, orderDiscount, orderTotal));
			}
			System.out.println("디테일 리스트 저장 DAO 완료");
			
			return list;
    		
		} catch (Exception e) {
			System.out.println("디테일 리스트 저장 DAO 오류 발생");
			cutConnect();
			return null;
		}
    }
    
    //히스토리 저장 메소드
    public boolean SaveGuestPaymentHistory(paymentHistoryVO ph) {
    	try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            
			String sql = "INSERT INTO paymentHistory (payDate, payNumber, tableNumber, customersName, customersId) VALUES (?,?,?,?,?)";
			System.out.println(sql);
			
			pstmt = conn.prepareStatement(sql);
			System.out.println("prepareStatement 생성됨");
			
			SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
			
			pstmt.setString(1, simple.format(ph.getPayDate()));
			System.out.println("prepareStatement 쿼리에 값 저장됨 : " + simple.format(ph.getPayDate()));
			
			pstmt.setInt(2, ph.getPayNumber());
			System.out.println("prepareStatement 쿼리에 값 저장됨 : " + ph.getPayNumber());
			
			pstmt.setInt(3, ph.getTableNumber());
			System.out.println("prepareStatement 쿼리에 값 저장됨 : " + ph.getTableNumber());
			
			pstmt.setString(4, ph.getCustomersName());
			System.out.println("prepareStatement 쿼리에 값 저장됨 : " + ph.getCustomersName());
			
			pstmt.setString(5, ph.getCustomersId());
			System.out.println("prepareStatement 쿼리에 값 저장됨 : " + ph.getCustomersId());
			
			pstmt.execute();
	        
			System.out.println("결제내역 히스토리 저장 실행됨");
			
            System.out.println("결제내역 히스토리 저장 DAO 완료");
            
			cutConnect();
			return true;
		} catch (Exception e) {
			System.out.println("결제내역 히스토리 저장 DAO 오류 발생");
			cutConnect();
			return false;
		}
    }
    
    //디테일 저장 메소드
    public boolean SaveGuestPaymentDetail(ArrayList<paymentDetailVO> list) {
    	try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            for (paymentDetailVO pv : list) {
				String sql = "INSERT INTO paymentDetails (payNumber, menuName, menuCost, orderCount, orderDiscount) VALUES (?,?,?,?,?)";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, pv.getPayNumber());
				pstmt.setString(2, pv.getMenuName());
				pstmt.setInt(3, pv.getMenuCost());
				pstmt.setInt(4, pv.getOrderCount());
				pstmt.setInt(5, pv.getOrderDiscount());
	            
				pstmt.execute();
				
	            System.out.println("결제내역 디테일 저장 실행됨");
			}
            System.out.println("결제내역 디테일 저장 DAO 완료");
            
			cutConnect();
			return true;
		} catch (Exception e) {
			System.out.println("결제내역 디테일 저장 DAO 오류 발생");
			cutConnect();
			return false;
		}
    }
    
    //메뉴를 불러오는 메소드
    public ArrayList<MenuVO> showAllMenu(String order, String orderSort)	{
    	try {
    		ArrayList<MenuVO> list = new ArrayList<MenuVO>();
    		
    		String sql = "SELECT * FROM menu AS t1 LEFT JOIN menucategory AS t2 ON t1.categoryNumber = t2.categoryNumber ORDER BY " + order + " " + orderSort;
    		System.out.println(sql);
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            st = conn.createStatement();
            System.out.println("스테이트먼트 객체 생성됨");
            
            rs = st.executeQuery(sql);
            System.out.println("리설트 객체 생성됨");
            
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
			System.out.println("메뉴 뷰어 DAO 오류 발생 : " + e);
			cutConnect();
			return null;
		}
    }
    
    public ArrayList<String> getCategoryList() {
    	try {
			
    		ArrayList<String> list = new ArrayList<String>();
    		String sql = "SELECT * FROM menucategory";
    		System.out.println(sql);
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            st = conn.createStatement();
            System.out.println("스테이트먼트 객체 생성됨");
            
            rs = st.executeQuery(sql);
            System.out.println("리설트 객체 생성됨");
            
            while (rs.next()) {
            	String categoryName = rs.getString("categoryName");
            	list.add(categoryName);
			}
            
            System.out.println("카테고리 리스트 DAO 완료");
            cutConnect();
            
            return list;
    		
		} catch (Exception e) {
			System.out.println("카테고리 리스트 DAO 오류 발생 : " + e);
			cutConnect();
			return null;
		}
    }
    
    public ArrayList<MenuVO> showAllCategoryMenu(String name) {
    	try {
			
    		ArrayList<MenuVO> list = new ArrayList<MenuVO>();
    		String sql = "SELECT * FROM menu AS t1 LEFT JOIN menucategory AS t2 ON t1.categoryNumber = t2.categoryNumber WHERE categoryName = '" + name + "'";
    		System.out.println(sql);
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            st = conn.createStatement();
            System.out.println("스테이트먼트 객체 생성됨");
            
            rs = st.executeQuery(sql);
            System.out.println("리설트 객체 생성됨");
            
            while (rs.next()) {
            	
            	int menuNumber = rs.getInt("menuNumber");
            	String menuName = rs.getString("menuName");
            	int menuCost = rs.getInt("menuCost");
            	int categoryNumber = rs.getInt("t1.categoryNumber");
            	String categoryName = rs.getString("categoryName");
            	
            	list.add(MenuVO.getInstence(menuNumber, menuName, menuCost, categoryNumber, categoryName));
            	
			}
            
            System.out.println("메뉴 리스트 불러오기 DAO 완료");
            cutConnect();
            
            return list;
    		
		} catch (Exception e) {
			System.out.println("메뉴 리스트 불러오기 DAO 오류 발생 : " + e);
			cutConnect();
			return null;
		}
    }
    
    public ArrayList<OrderVO> showMyOrder(String tableNumber, String categoryName) {
    	try {
    		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
    		String sql = "SELECT * FROM tableorder AS t1 LEFT JOIN menucategory AS t2 ON t1.categoryNumber = t2.categoryNumber WHERE tableNumber = " + tableNumber + " AND categoryName = '" + categoryName + "'";
    		System.out.println(sql);
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            st = conn.createStatement();
            System.out.println("스테이트먼트 객체 생성됨");
            
            rs = st.executeQuery(sql);
            System.out.println("리설트 객체 생성됨");
            
            while (rs.next()) {
        		String orderName = rs.getString("orderName");
        		int orderCount = rs.getInt("orderCount");
        		int orderDiscount = rs.getInt("orderDiscount");
        		
        		list.add(new OrderVO(orderName, orderCount, orderDiscount));
			}
            
            System.out.println("메뉴 리스트 불러오기 DAO 완료");
            cutConnect();
            
            return list;
    		
		} catch (Exception e) {
			System.out.println("메뉴 리스트 불러오기 DAO 오류 발생 : " + e);
			cutConnect();
			return null;
		}
    }
    
    public boolean checkOrderName(String tableNumber, String orderName) {
    	try {
    		boolean check = true;
    		
    		String sql = "SELECT * FROM tableorder WHERE tableNumber = " + tableNumber + " AND orderName = '" + orderName + "' LIMIT 1";
    		System.out.println(sql);
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            st = conn.createStatement();
            System.out.println("스테이트먼트 객체 생성됨");
            
            rs = st.executeQuery(sql);
            while (rs.next()) {
            	check = false;
			}
            
            System.out.println("현 주문내역 리턴 DAO 완료");
			cutConnect();
			
			return check;
			
		} catch (Exception e) {
			System.out.println("현 주문내역 리턴 DAO 오류 발생");
			cutConnect();
			return false;
		}
    }
    
    public boolean oldOrderPlus(String plusCount, String tableNumber, String orderName) {
    	try {
			String sql = "UPDATE tableorder AS t1 SET orderCount = t1.orderCount + " + plusCount + " WHERE tableNumber = " + tableNumber + " AND orderName = '" + orderName + "'";
			System.out.println(sql);
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            pstmt = conn.prepareStatement(sql);
			System.out.println("prepareStatement 생성됨");
			
			pstmt.execute();
            
            System.out.println("이전 주문내역 추가주문 DAO 완료");
			cutConnect();
    		return true;
    		
    	} catch (Exception e) {
    		
    		System.out.println("이전 주문내역 추가주문 DAO 오류 발생");
			cutConnect();
			return false;
		}
    }
    
    public boolean newOrderPlus(String orderName, String orderCost, String orderCount, String tableNumber, String categoryNumber) {
    	try {
    		
    		String sql = "INSERT INTO tableorder (tableNumber, orderName, orderCost, orderCount, categoryNumber) VALUES (?,?,?,?,?)";
    		System.out.println(sql);
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            pstmt = conn.prepareStatement(sql);
			System.out.println("prepareStatement 생성됨");
			
			pstmt.setInt(1, Integer.parseInt(tableNumber));
			System.out.println("prepareStatement 쿼리에 값 저장됨 : " + tableNumber);
			
			pstmt.setString(2, orderName);;
			System.out.println("prepareStatement 쿼리에 값 저장됨 : " + orderName);
			
			pstmt.setInt(3, Integer.parseInt(orderCost));
			System.out.println("prepareStatement 쿼리에 값 저장됨 : " + orderCost);
			
			pstmt.setInt(4, Integer.parseInt(orderCount));
			System.out.println("prepareStatement 쿼리에 값 저장됨 : " + orderCount);
			
			pstmt.setInt(5, Integer.parseInt(categoryNumber));
			System.out.println("prepareStatement 쿼리에 값 저장됨 : " + categoryNumber);
			
			pstmt.execute();
            
            System.out.println("현 주문내역 리턴 DAO 완료");
			cutConnect();
    		return true;
    		
		} catch (Exception e) {
			System.out.println("현 주문내역 리턴 DAO 오류 발생");
			cutConnect();
			return false;
		}
    }
	
	private void DBAutoIncrementSort() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
			System.out.println("mysql : 데이터베이스 오토 인크리먼트 재갱신 시작");
			
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
			System.out.println("mysql : 테이블 데이터베이스 오토 인크리먼트 재갱신 완료");
			
			
			
			sql1 = "ALTER TABLE tableorder AUTO_INCREMENT=1";
			sql2 = "SET @COUNT = 0";
			sql3 = "UPDATE tableorder SET orderNumber = @COUNT:=@COUNT+1";
			pstmt = conn.prepareStatement(sql1);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql2);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql3);
			pstmt.executeUpdate();
			System.out.println("mysql : 오더 데이터베이스 오토 인크리먼트 재갱신 완료");
			
			cutConnect();
			
		} catch (Exception e) {
			cutConnect();
			System.out.println("mysql : 데이터베이스 오토 인크리먼트 재갱신 오류발생\n");
		}
		
	}
	
	private final void cutConnect() {
    	try {
    		
			if (conn != null) conn.close();
			if (pstmt != null) pstmt.close();
			if (st != null) st.close();
			if (rs != null) rs.close();
			
		} catch (Exception e) {
			System.out.println("DB 연결 삭제 실패");
		}
    }
	
}
