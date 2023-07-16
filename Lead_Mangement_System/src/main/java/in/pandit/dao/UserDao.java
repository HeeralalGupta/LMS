package in.pandit.dao;

import java.sql.Connection;
<<<<<<< HEAD
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.pandit.Entity.UserEntity;
import in.pandit.persistance.DatabaseConnection;

public class UserDao {
//	private static final String GET_USER_INFO = "SELECT * FROM users WHERE email=?";
	private static final String IS_EMAIL_REGISTERD = "SELECT * FROM users WHERE email=?";
	private static final String IS_MOBILE_REGISTERD = "SELECT * FROM users WHERE mobile=?";
	
    public static UserEntity getUserEmailInfo(String email){
    	UserEntity emailInfo = new UserEntity();
    	try {
        	Connection con = DatabaseConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(IS_EMAIL_REGISTERD);
            pst.setString(1, email);
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
            	emailInfo.setId(rst.getString("id"));
            	emailInfo.setName(rst.getString("name"));
            	emailInfo.setEmail(rst.getString("email"));
            	emailInfo.setMobile(rst.getString("mobile"));
            	emailInfo.setPassword(rst.getString("password"));
            	emailInfo.setCfpassword(rst.getString("cfpassword"));
            }
        } catch (Exception e) {
        }
        return emailInfo;
    }
    public static UserEntity getUserMobileInfo(String mobile){
    	UserEntity mobileInfo = new UserEntity();
    	try {
        	Connection con = DatabaseConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(IS_MOBILE_REGISTERD);
            pst.setString(1, mobile);
            ResultSet rst = pst.executeQuery();
            while(rst.next()){
            	mobileInfo.setId(rst.getString("id"));
                mobileInfo.setName(rst.getString("name"));
                mobileInfo.setEmail(rst.getString("email"));
                mobileInfo.setMobile(rst.getString("mobile"));
            }
        } catch (Exception e) {
        }
        return mobileInfo;
    }
    public static boolean validate(String email,String password) {
        boolean status = false;

        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "select * from users where email=? and password=?");

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            status = rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;

    }

    public static int RegisterUser(UserEntity ur) {
        int st = 0;

        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO users(id,name,email,mobile,password,cfpassword) VALUES (?,?,?,?,?,?)");
            ps.setString(1, Long.toString(System.currentTimeMillis()));
            ps.setString(2, ur.getName());
            ps.setString(3, ur.getEmail());
            ps.setString(4, ur.getMobile());
            ps.setString(5, ur.getPassword());
            ps.setString(6, ur.getCfpassword());

            st = ps.executeUpdate();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }
    
=======
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.pandit.Entity.UserEntity;
import in.pandit.persistance.DatabaseConnection;

public class UserDao {
	private static final String LOGIN_QUERY = "SELECT * FROM users WHERE email=? AND password=?";
	
	
	public static UserEntity login(String email,String password) {
		UserEntity user = new UserEntity();
		Connection con = DatabaseConnection.getConnection();
		try {
			PreparedStatement pst = con.prepareStatement(LOGIN_QUERY);
			pst.setString(1, email);
			pst.setString(2, password);
			
			ResultSet rst = pst.executeQuery();
			while(rst.next()) {
				user.setId(rst.getInt("id"));
				user.setName(rst.getString("name"));
				user.setEmail(rst.getString("email"));
				user.setMobile(rst.getString("mobile"));
				user.setPassword(rst.getString("password"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
>>>>>>> refs/remotes/origin/gopal2
}
