package Model.UserModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UserDAO {
	
	private Connection conn = null;
    private PreparedStatement pstmt = null;
    private Statement st = null;
    private ResultSet rs = null;
    
    //private String url="jdbc:mysql://117.17.113.248:3306/restaurant?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
    //private String url="jdbc:mysql://27.96.134.5/postboard?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
    private static final String url="jdbc:mysql://localhost:33115/restaurant?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
    private String uid="hgf107103";
    private String upass="Hwt0147258!";
    private UserVO uv = null;
    
    private UserDAO() {}
    
    public static UserDAO getInstance() {
    	return new UserDAO();
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

            System.out.println(name + " : " +  userid + " : " +  userpass + " : " +  sex);
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
            pstmt.execute();
            System.out.println("회원가입 쿼리 성공");
            
            cutConnect();
            return true;
		} catch (Exception e) {
			
			cutConnect();
			return false;
		}
    }
	
	//로그인 아이디 검사용
	public boolean loginIdCheak(String id) {
		try {
    		String sql = "SELECT * FROM user WHERE userid = '" + id + "'";
    		String userid = null;
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 적재됨");

            System.out.println(sql);
            
            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("아이디 체크 쿼리실행완료");
            
            while(rs.next()) {
            	userid = rs.getString("userid");
            }
            System.out.println("아이디 체크 값 적재 완료");
            
            cutConnect();
            
            if (userid.equals(id)) {
            	System.out.println("존재하는 아이디");
            	return true;
			} else {
				System.out.println("존재하지 않는 아이디");
				return false;
			}
            
		} catch (Exception e) {
			
			cutConnect();
			System.out.println("로그인 아이디 체크 오류 발생" + e);
			return false;
		}
	}
	
	//아래 함수는 회원가입 중복체크용
	public boolean idCheak(String id) {
		try {
    		String sql = "SELECT * FROM user WHERE userid = '" + id + "'";
    		String userid = null;
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            System.out.println("아이디 체크 쿼리실행완료");
            
            while(rs.next()) {
            	userid = rs.getString("userid");
            }
            System.out.println("아이디 체크 값 적재 완료");
            
            cutConnect();
            
            if (userid == null) {
            	System.out.println("아이디 체크 이상없음");
            	return true;
			} else {
				System.out.println("아이디 체크 중복아이디 있음");
				return false;
			}
            
		} catch (Exception e) {
			
			cutConnect();
			System.out.println("아이디 체크 오류 발생");
			return false;
		}
	}
	
	public ArrayList<UserVO> showAllUser() {
		try {
			
			ArrayList<UserVO> list = new ArrayList<UserVO>();
			
			String sql = "SELECT * FROM user";
    		String userid = null;
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이브 적재됨");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB 연동됨");
            
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            while (rs.next()) {
            	String name = rs.getString("name");
            	String id = rs.getString("userid");
            	String pass = rs.getString("userpass");
            	String sex = rs.getString("sex");
            	list.add(new UserVO(name, id, pass, sex));
			}
            
            cutConnect();
            return list;
            
		} catch (Exception e) {
			cutConnect();
			System.out.println("아이디 체크 오류 발생");
			return null;
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
