package org.jspiders.jdbcApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Particularname {
	 public static void main(String args[])
	   {
		   Connection con=null;
		   PreparedStatement pstmt=null;
		   ResultSet rs=null;
		   String qry="select * from btm.student where name=?";
		   Scanner sc=new Scanner(System.in);
		   System.out.println("Enter Name???");
		   String name=sc.nextLine();
		   sc.close();
		   try
		   {
			   Class.forName("com.mysql.cj.jdbc.Driver");
			   con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			   pstmt=con.prepareStatement(qry);
			   //set the value for placeholder before execution//
			   pstmt.setString(1, name);
			   //Execute SQL Query//
			   rs=pstmt.executeQuery();
			   //check for record in cursor or buffer memory //
			   if(rs.next())
			   {
				   int id=rs.getInt(1);
				   double perc=rs.getDouble(3);
				   System.out.println("Id="+id+ " perc="+perc);
			   }
			   else 
			   {
				   System.err.println("No data found for id = "+name); 
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
