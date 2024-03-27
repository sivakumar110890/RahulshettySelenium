package dataBaseConnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.DataProvider;

public class JDBCConnections {

	static String name = null;
	static String location = null;

	@org.testng.annotations.Test(dataProvider = "SeleniumDataProvider")
	public static void Test(String[] data) {
		String name1 = data[0];
		String location1 = data[1];
		System.out.println("Name is : " + name1);
		System.out.println("Location is : " + location1);

	}

	@DataProvider(name="SeleniumDataProvider")
	public static String[][] DataBaseConnection() throws SQLException {
		String hostname = "localhost";
		String username = "root";
		String password = "root";
		String port = "3306";
		String DatabaseName = "QADB";
		Connection con = DriverManager.getConnection("jdbc:mysql://" + hostname + ":" + port + "/" + DatabaseName,
				username, password);
		// System.out.println("Connection happened");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from EmployeeInfo where name='balaji V'");
		while (rs.next()) {
			name = rs.getString("name");
			location = rs.getString("location");
		//	System.out.println("name : " + name);
			//System.out.println("Location : " + location);
		}
		return new String[][] {{ name, location} };

	}

}
