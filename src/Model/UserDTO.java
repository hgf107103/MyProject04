package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDTO {
	
	private Connection conn = null;
    private PreparedStatement pstmt = null;
    private Statement st = null;
    private ResultSet rs = null;

    private String url="jdbc:mysql://117.17.113.248:3306/postboard?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
    private String uid="master";
    private String upass="123456";
    private UserVO uv = null;
    
    private UserDTO() {}
    
    public static UserDTO getInstance() {
    	return new UserDTO();
    } 

    public UserVO login(String id, String pwd) {
        try {
            String sql = "SELECT * FROM user WHERE userid = '" + id + "' AND userpass = '" + pwd + "'";

            String userid = null;
            String userpass = null;
            String name = null;
            String sex = null;
            System.out.println("문자열 세팅됨");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");

            st = conn.createStatement();
            System.out.println("Statement 생성됨");

            rs = st.executeQuery(sql);
            
            System.out.println("Result Set 생성됨");
            
            while(rs.next()) {
                userid = rs.getString("userid");
                userpass = rs.getString("userpass");
                name = rs.getString("name");
                sex = rs.getString("sex");
            }

            System.out.println("Result값 생성됨");
            
            if (userid != null && userpass != null && name != null && sex != null) {
            	uv = new UserVO(name, userid, userpass, sex);
                System.out.println("로그인 성공");
                cutConnect();
                return uv;
            } else {
            	cutConnect();
            	System.out.println("로그인 실패");
                return null;
            }


        }catch (Exception e) {
            System.out.println("DB 연동 실패");
            cutConnect();
            return null;
        }
    }
    
	public boolean signUp(UserVO uv) {
    	try {
    		String sql = "INSERT INTO user (userid, userpass, name, sex) values ('" + uv.getId() + "', '" + uv.getPwd() + "', '" + uv.getName() + "', '" + uv.getSex() + "')";
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            pstmt = conn.prepareStatement(sql);
            System.out.println("회원가입 쿼리 성공");
            
            cutConnect();
            return true;
		} catch (Exception e) {
			
			cutConnect();
			return false;
		}
    }
    
    private void cutConnect() {
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
