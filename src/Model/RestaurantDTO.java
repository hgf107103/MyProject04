package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class RestaurantDTO {
	
	private Connection conn = null;
    private PreparedStatement pstmt = null;
    private Statement st = null;
    private ResultSet rs = null;

    private String url="jdbc:mysql://117.17.113.248:3306/restaurant?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
    private String uid="master";
    private String upass="123456";
    private RestaurantDTO uv = null;
    
    private RestaurantDTO() {}
    
    public static RestaurantDTO getInstance() {
    	return new RestaurantDTO();
    }
}
