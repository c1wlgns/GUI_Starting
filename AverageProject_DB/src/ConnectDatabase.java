import java.sql.*;

public class ConnectDatabase {
	public static Connection makeConnection()
 {
 String url = "jdbc:mysql://localhost/test?serverTimezone=UTC";
 String id = "root";
 String password = "1234";
 Connection con = null;
 try {
 Class.forName("com.mysql.jdbc.Driver");
 System.out.println("����̹� ���� ����");
 con = DriverManager.getConnection(url, id, password);
 System.out.println("�����ͺ��̽� ���� ����"); 
 } catch (ClassNotFoundException e) {
 System.out.println("����̹��� ã�� �� �����ϴ�.");
 } catch (SQLException e) {
 System.out.println("���ῡ �����Ͽ����ϴ�.");
 }
 return con; 
 }
	public static void main(String arg[]) throws SQLException{
		Connection con = makeConnection();
	}

	private static Connection makeConnection1() {
		return null;
	} 
} 
