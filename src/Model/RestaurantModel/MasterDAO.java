package Model.RestaurantModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
				categoryNumber = rs.getInt("idx");
			}
            
            cutConnect();
            return categoryNumber;
            
		} catch (Exception e) {
			System.out.println("카테고리 체크 DAO 오류 발생");
			cutConnect();
			return -1;
		}
    }
    
    public boolean updateMenu(String name) {
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
			// TODO: handle exception
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
    public void DBAutoIncrementSort() {
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
			
			
			sql1 = "ALTER TABLE rsmaster AUTO_INCREMENT=1";
			sql2 = "SET @COUNT = 0";
			sql3 = "UPDATE rsmaster SET idx = @COUNT:=@COUNT+1";
			pstmt = conn.prepareStatement(sql1);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql2);
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql3);
			pstmt.executeUpdate();
			System.out.println("mysql : 카운터 데이터베이스 오토 인크리먼트 재갱신 완료\n");
			
			cutConnect();
			
		} catch (Exception e) {
			cutConnect();
			System.out.println("mysql : 데이터베이스 오토 인크리먼트 재갱신 오류발생\n");
		}
		
	}
    
}
