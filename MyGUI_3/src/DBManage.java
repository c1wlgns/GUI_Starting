import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane; 

public class DBManage {
	public static Connection con;
	public static Statement stmt;
	public static ResultSet rs;

	public void DBSetting() {
		try {
			Class.forName("com.mysql.tdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/?serverTimezone = UTC", "root", "1234");
			stmt = con.createStatement();
			JOptionPane.showMessageDialog(null, "MySQL... Ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
 
	}

	public static ResultSet ExceQuery(String sql) {
		try {
			stmt = con.createStatement();
			return stmt.executeQuery(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public static boolean ExecFind(String sql, String name) {
		try {
			rs = ExceQuery(sql);
			while(rs.next()) {
				if(rs.getString(1).equals(name)) return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
 
}
