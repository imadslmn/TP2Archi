package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Interfaces.InterfaceDBConnection;

public class DBConnection implements InterfaceDBConnection {
	   
		static String BDD = "library_books";
		static String url = "jdbc:mysql://localhost:3306/" + BDD;
		static String user = "root";
		static String passwd = "";
	    private static Connection conn;
	    private DBConnection() throws SQLException  {
		}
		public static synchronized Connection getConn() throws SQLException {
			if(conn == null)
				try{
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection(url,user, passwd);
				}catch(Exception ex){
					System.out.println(ex.getMessage());
					System.out.println("couldn't connect!");
					throw new RuntimeException(ex);
				}
			return conn;
		}

}
