package org.jspiders.jdbcApp;

import java.sql.*;

public class jdbcDemo {
	public static void main(String args[])
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Drive class loaded&Registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection Established With DataBase Server");
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try
				{
					con.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				System.out.println("Closed all Costly Resources");
			}
		}
	}

}
