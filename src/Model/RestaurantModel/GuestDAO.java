package Model.RestaurantModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GuestDAO {
	
	private Connection conn = null;
    private PreparedStatement pstmt = null;
    private Statement st = null;
    private ResultSet rs = null;

    //private String url="jdbc:mysql://117.17.113.248:3306/restaurant?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
    private String url="jdbc:mysql://27.96.134.5:3306/restaurant?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
    private String uid="hgf107103";
    private String upass="Hwt0147258!";
    
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
