import java.sql.*;
public class Connectivity {
static Connection connection = null;
	static String databasename="";
	static String url = "jdbc:mysql://localhost:3306/"+databasename;
	
	static String username = "root";
	static String password = "Gaurmitt@1234";
		
	
	
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Class.forName("com.mysql.jdbc.Driver").	newInstance();
		connection = DriverManager.getConnection(url,username,password);
//		PreparedStatement ps = connection.prepareStatement("insert into `studentdatabase`.`student` (`name`) values ('gaurang'); ");
//		int status  = ps.executeUpdate();
//		if(status!=0)
//		{
//			System.out.println("database connected");
//			System.out.println("record was inserted");
//			
//		}
		connection.close();
	}
  
}