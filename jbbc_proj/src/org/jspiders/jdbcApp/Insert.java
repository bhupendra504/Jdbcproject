package org.jspiders.jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
	public static void main(String args[])
	{
		Connection con=null;
		Statement stmt=null;
		String qry="insert btm.student values(6,'shivani',68.5)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Drive class loaded&Registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection Established With DataBase Server");
			stmt=con.createStatement();
			System.out.println("Platform Created");
			stmt.executeUpdate(qry);
			System.out.println("insert data!!!!!!");
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(stmt!=null)
			{
				try
				{
					stmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
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
