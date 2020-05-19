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
			System.out.println("DB 연결 삭제 실패");
		}
    }
    
    public boolean addNewMenu(MenuVO mv) {
    	try {
    		String sql = "INSERT INTO menu (menuName, menuCost, categoryNumber) values ('" + mv.getMenuName() + "', " + mv.getMenuCost() + ", " + mv.getCategoryNumber() +")";
    		System.out.println(sql);
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            pstmt = conn.prepareStatement(sql);
            pstmt.execute();
            System.out.println("메뉴 추가 쿼리 성공");
            
            DBAutoIncrementSort();
            cutConnect();
			return true;
		} catch (Exception e) {
			System.out.println("메뉴 추가 DAO 오류 발생");
			cutConnect();
			return false;
		}
    }
    
    public boolean addMenuNameCheck(String menuName) {
    	try {
    		String sql = "SELECT * FROM menu WHERE menuName = '" + menuName + "'";
    		System.out.println(sql);
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            st = conn.createStatement();
            System.out.println("스테이트먼트 객체 생성됨");
            
            rs = st.executeQuery(sql);
            
            while (rs.next()) {
				if (rs.getString("menuName").equals(menuName)) {
					return false;
				}
			}
            
            cutConnect();
            return true;
            
		} catch (Exception e) {
			System.out.println("메뉴 추가 이름체크 DAO 오류 발생");
			cutConnect();
			return false;
		}
    }
    
    public int checkCategory (String category) {
    	try {
    		String sql = "SELECT * FROM menucategory WHERE categoryName = '" + category + "'";
    		System.out.println(sql);
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            st = conn.createStatement();
            System.out.println("스테이트먼트 객체 생성됨");
            
            int categoryNumber = 0;
            rs = st.executeQuery(sql);
            System.out.println("리설트 셋 객체 생성됨");
            
            while (rs.next()) {
				categoryNumber = rs.getInt("categoryNumber");
			}
            
            cutConnect();
            return categoryNumber;
            
		} catch (Exception e) {
			System.out.println("카테고리 체크 DAO 오류 발생 : " + e);
			cutConnect();
			return -1;
		}
    }
    
    public boolean isMenuDataChanged(MenuVO mv) {
    	try {
    		String sql = "SELECT * FROM menu WHERE menuNumber = " + mv.getMenuNumber() + " AND menuName = '" + mv.getMenuName() +" ' AND menuCost = " + mv.getMenuCost() + " AND categoryNumber = " + mv.getCategoryNumber();
    		System.out.println(sql);
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            st = conn.createStatement();
            System.out.println("스테이트먼트 객체 생성됨");
            
            rs = st.executeQuery(sql);
            
            while (rs.next()) {
            	System.out.println("수정되지 않음. return false");
            	return false;
			}
            System.out.println("수정체크됨. return true");
			return true;
			
		} catch (Exception e) {
			cutConnect();
			System.out.println("메뉴 수정 변경점 검사 DAO 오류 발생 : " + e);
			return false;
		}
    }
    
    public boolean updateMenu(MenuVO mv) {
    	try {
    		if (mv.getCategoryNumber() > 0) {
    			
    			String sql = "UPDATE menu SET menuName = '" + mv.getMenuName() + "', menuCost = " + mv.getMenuCost() + ", categoryNumber = " + mv.getCategoryNumber() + " WHERE menuNumber = " + mv.getMenuNumber();
        		System.out.println(sql);
        		
        		Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("드라이브 적재됨");

                conn = DriverManager.getConnection(url, uid, upass);
                System.out.println("DB 연동됨");
                
                pstmt = conn.prepareStatement(sql);
                pstmt.execute();
                System.out.println("메뉴 추가 쿼리 성공");
                
                DBAutoIncrementSort();
                cutConnect();
    			return true;
    			
			} else {
				cutConnect();
				System.out.println("메뉴 업데이트 DAO 카테고리번호 오류 발생");
				return false;
			}
    		
		} catch (Exception e) {
			cutConnect();
			System.out.println("메뉴 업데이트 DAO 오류 발생 : " + e);
			return false;
		}
    }
    
    public boolean deleteMenu(MenuVO mv) {
    	try {
    		
    		String sql = "DELETE FROM menu WHERE menuNumber = " + mv.getMenuNumber() + " AND menuName = '" + mv.getMenuName() +" ' AND menuCost = " + mv.getMenuCost() + " AND categoryNumber = " + mv.getCategoryNumber();
    		System.out.println(sql);
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            pstmt = conn.prepareStatement(sql);
            System.out.println("프리페어스테이트먼트 객체 생성됨");
            
            pstmt.execute();
            System.out.println("메뉴 추가 쿼리 성공");
            
            DBAutoIncrementSort();
            cutConnect();
            return true;
            
		} catch (Exception e) {
			
			cutConnect();
			System.out.println("메뉴 추가 쿼리 오류 발생");
			return false;
		}
    }
    
    public MenuVO showOneMenu(String name) {
    	try {
    		MenuVO mv = MenuVO.getInstence();
    		
    		String sql = "SELECT * FROM menu AS t1 LEFT JOIN menucategory AS t2 ON t1.categoryNumber = t2.categoryNumber WHERE menuName = '" + name + "'"; 
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
				mv.setMenuNumber(rs.getInt("menuNumber"));
				mv.setMenuName(rs.getString("menuName"));
				mv.setMenuCost(rs.getInt("menuCost"));
				mv.setCategoryNumber(rs.getInt("categoryNumber"));
				mv.setCategoryName(rs.getString("categoryName"));
			}
            System.out.println("menu VO 값 저장됨");
            
            cutConnect();
            if (mv.getMenuName() != null) {
            	return mv;
			} else {
				return null;
			}
			
		} catch (Exception e) {
			System.out.println("메뉴 뷰어 DAO 오류 발생 : " + e);
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
    
    //데이터베이스의 오토인크리먼트값 sort
    private void DBAutoIncrementSort() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
			System.out.println("mysql : 데이터베이스 오토 인크리먼트 재갱신 시작");
			
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
			System.out.println("mysql : 메뉴 데이터베이스 오토 인크리먼트 재갱신 완료");
			
			
			
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
    
    
    //이하 테이블 관련 데이터 엑세스 오브젝트 메소드
    
    public boolean addNewTable() {
    	try {
    		String sql = "INSERT INTO mytable () values ()";
    		System.out.println(sql);
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            pstmt = conn.prepareStatement(sql);
            pstmt.execute();
            System.out.println("테이블 추가 쿼리 성공");
            
            DBAutoIncrementSort();
            cutConnect();
			return true;
			
		} catch (Exception e) {
			System.out.println("테이블 추가 DAO 오류 발생");
			cutConnect();
			return false;
		}
    }
    
    public boolean deleteTableCheck() {
    	try {
    		String sql = "SELECT * FROM mytable ORDER BY tableNumber DESC LIMIT 1";
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
            	if (rs.getString("customersId") != null) {
            		cutConnect();
					return false;
				}
			}
            
            cutConnect();
            return true;
            
		} catch (Exception e) {
			System.out.println("테이블 삭제 체크 DAO 오류 발생 : " + e);
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
                System.out.println("드라이브 적재됨");

                conn = DriverManager.getConnection(url, uid, upass);
                System.out.println("DB 연동됨");
                
                pstmt = conn.prepareStatement(sql);
                pstmt.execute();
                System.out.println("테이블 삭제 쿼리 성공");
                
                DBAutoIncrementSort();
    			cutConnect();
        		return true;
			} else {
				System.out.println("테이블 삭제 DAO 오류 발생 : 마지막 테이블 손님 존재");
				cutConnect();
				return false;
			}
    		
		} catch (Exception e) {
			System.out.println("테이블 삭제 DAO 오류 발생 : " + e);
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
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            st = conn.createStatement();
            System.out.println("스테이트먼트 객체 생성됨");
            
            rs = st.executeQuery(sql);
            System.out.println("리설트 객체 생성됨");
            
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
				System.out.println("테이블 넘버 : " + tableVO.getTableNumber());
				System.out.println("고객 이름 : " + tableVO.getCustomersName());
				System.out.println("고객 아이디 : " + tableVO.getCustomersId());
				System.out.println("테이블 합계 : " + tableVO.getCostTotal());
			}
            cutConnect();
            return list;
			
			
		} catch (Exception e) {
			System.out.println("테이블 리스트 DAO 오류 발생 : " + e);
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
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            st = conn.createStatement();
            System.out.println("스테이트먼트 객체 생성됨");
            
            rs = st.executeQuery(sql);
            System.out.println("리설트 객체 생성됨");
			
            while (rs.next()) {
            	count++;
            	int tableNumber = rs.getInt("tableNumber");
            	String orderName = rs.getString("orderName");
            	int orderCost = rs.getInt("orderCost");
            	int orderCount = rs.getInt("orderCount");
            	int orderDiscount = rs.getInt("orderDiscount");
            	int orderTotal = rs.getInt("orderTotal");
            	list.add(new OrderVO(tableNumber, orderName, orderCost, orderCount, orderDiscount, orderTotal));
            	System.out.println("테이블넘버 : " + tableNumber);
            	System.out.println(orderName);
            	System.out.println(orderCost);
            	System.out.println(orderCount);
            	System.out.println(orderDiscount);
            	System.out.println(orderTotal);
			}
            System.out.println("OrderVO 객체 생성됨");
            
            if (count > 0) {
            	System.out.println("OrderVO 객체 전달됨");
            	cutConnect();
            	return list;
			} else {
				System.out.println("OrderVO 객체 리스트 없음, null 전달됨");
				cutConnect();
				return null;
			}
            
            
		} catch (Exception e) {
			System.out.println("테이블 상세보기 DAO 오류 발생 : " + e);
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
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            st = conn.createStatement();
            System.out.println("스테이트먼트 객체 생성됨");
            
            rs = st.executeQuery(sql);
            System.out.println("리설트 객체 생성됨");
			
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
            System.out.println("paymentHistoryVO 객체 생성됨");
            
            cutConnect();
            return list;
			
            
            
		} catch (Exception e) {
			System.out.println("결제내역 히스토리 DAO 오류 발생 : " + e);
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
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            st = conn.createStatement();
            System.out.println("스테이트먼트 객체 생성됨");
            
            rs = st.executeQuery(sql);
            System.out.println("리설트 객체 생성됨");
			
            while (rs.next()) {
            	int payNumber = rs.getInt("payNumber");
            	String menuName = rs.getString("menuName");
            	int menuCost = rs.getInt("menuCost");
            	int orderCount = rs.getInt("orderCount");
            	int orderDiscount = rs.getInt("orderDiscount");
            	int orderTotal = rs.getInt("orderTotal");
            	list.add(new paymentDetailVO(payNumber, menuName, menuCost, orderCount, orderDiscount, orderTotal));
			}
            System.out.println("paymentDetailVO 객체 생성됨");
            
            cutConnect();
            return list;
			
            
            
		} catch (Exception e) {
			System.out.println("결제내역 상세보기 DAO 오류 발생 : " + e);
			cutConnect();
			return null;
		}
    }
    	
    
}
