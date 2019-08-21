package com.cg.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil 
{
	static Connection con;
	
	static
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@10.51.103.201:1521:orcl11g";
			String user = "lab2etrg30";
			String passwd = "lab2eoracle";
            con = DriverManager.getConnection(url,user,passwd);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static Connection getConnection()
	{
		return con;
	}

}
