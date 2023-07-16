package in.pandit.dao;

import java.sql.Connection;
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
				user.setEmail(rst.getString("email"));
				user.setMobile(rst.getString("mobile"));
				user.setName(rst.getString("name"));
				user.setPassword(rst.getString("password"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
