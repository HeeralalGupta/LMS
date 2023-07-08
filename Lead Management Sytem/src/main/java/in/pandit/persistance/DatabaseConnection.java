package in.pandit.persistance;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	public static void Connect() {
		try {
			String url = "jdbc:postgresql://localhost:5432/LMS";
			String user = "postgres";
			String pass = "admin";
			Connection conn = DriverManager.getConnection(url, user, pass);
			if(conn != null) {
				System.out.println("Database Connected Successfully");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public static void main(String[] args) {
		DatabaseConnection.Connect();
	}
}
