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
            System.out.println("���ڿ� ���õ�");
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("����̺� �����");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB ������");

            st = conn.createStatement();
            System.out.println("Statement ������");

            rs = st.executeQuery(sql);
            
            System.out.println("Result Set ������");
            
            while(rs.next()) {
                userid = rs.getString("userid");
                userpass = rs.getString("userpass");
                name = rs.getString("name");
                sex = rs.getString("sex");
            }

            System.out.println("Result�� ������");
            
            if (userid != null && userpass != null && name != null && sex != null) {
            	uv = new UserVO(name, userid, userpass, sex);
                System.out.println("�α��� ����");
                cutConnect();
                return uv;
            } else {
            	cutConnect();
            	System.out.println("�α��� ����");
                return null;
            }


        }catch (Exception e) {
            System.out.println("DB ���� ����");
            cutConnect();
            return null;
        }
    }
    
	public boolean signUp(UserVO uv) {
    	try {
    		String sql = "INSERT INTO user (userid, userpass, name, sex) values ('" + uv.getId() + "', '" + uv.getPwd() + "', '" + uv.getName() + "', '" + uv.getSex() + "')";
    		
    		Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("����̺� �����");

            conn = DriverManager.getConnection(url, uid, upass);
            System.out.println("DB ������");
            
            pstmt = conn.prepareStatement(sql);
            System.out.println("ȸ������ ���� ����");
            
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
			System.out.println("DB ���� ���� ����");
		}
    }
	
}
