package aPIs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

/*Establish a database connection to get a Connection object.
Create a Statement object from the Connection object.
Execute the INSERT statement.
Close the database connection.*/
public class JdbcTest {
	@Test
	public void displayvalues() {
		Connection conn = null;
		String url = "jdbc:postgresql:postgres?user=postgres&password=Function@8";
		try {
			conn = DriverManager.getConnection(url);
			if (conn != null) {
				System.out.println("connection successfull");
			}
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from employee");
			while (rs.next()) {
				System.out.println(rs.getInt("employeeid") + " " + rs.getString("firstname"));

			}

			conn.close();
		}

		catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
}
