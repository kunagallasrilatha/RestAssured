package aPIs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class Databasetesting {
@Test
public void insertdat() throws SQLException
{
	
	Connection conn=DriverManager.getConnection("jdbc:postgresql:postgres?user=postgres&password=Function@8");
	
	if(conn!=null) {
		System.out.println("connection successfull");
	}
	Statement s=conn.createStatement();

	ResultSet rs=s.executeQuery("insert into employee values(51659,'aaa','mach','dasf@gmail.com')");

	
	  while(rs.next()) { System.out.println(rs.getInt("employeeid") + "  " +
	  rs.getString("firstname")); }
	 

	conn.close();
	}
}