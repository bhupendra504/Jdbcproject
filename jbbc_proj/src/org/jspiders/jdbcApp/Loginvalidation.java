package org.jspiders.jdbcApp;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
public class Loginvalidation {
	public static void main(String args[])
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select fullname from btm.user where name=? and password=?";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name");
		String name=sc.nextLine();
		System.out.println("Enter the password");
		String password=sc.nextLine();
		sc.close();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt=con.prepareStatement(qry);
			//set the value for placeholder before Execution//
			pstmt.setString(1,name);
			pstmt.setString(2,password);
			//Execute sql Query//
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
			
				String fullname=rs.getString(1);
				System.out.println("Welcome "+fullname);
			}
				
			else 
			{
				System.out.println("Invaild name/password");
			}
		}
		catch(ClassNotFoundException | SQLException e)
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
			if(pstmt!=null)
			{
				try
				{
					pstmt.close();
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
		}
		
	}
	

}
