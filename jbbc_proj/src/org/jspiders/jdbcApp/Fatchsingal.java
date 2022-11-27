package org.jspiders.jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Fatchsingal {
	public static void main(String args[])
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select * from btm.student";
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver class loaded and register");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection Established");
			pstmt=con.prepareStatement(qry);
			System.out.println("platform created");
			
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				int id=rs.getInt("id");
				String name=rs.getString(2);
				double percentage=rs.getDouble(3);
				System.out.println(id+" "+name+" "+percentage);
				
				System.out.println("Data Fatched!.....");
			}
		}
		catch(ClassNotFoundException |SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
			{
				try
				{
					rs.close();
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
			}
			System.out.println("All costly Resource Closed");
		}
	}

	

}
