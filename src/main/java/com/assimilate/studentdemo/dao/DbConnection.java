package com.assimilate.studentdemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	public static Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/sys";
			Connection con=DriverManager.getConnection(url,"root","root");
			return con;
			}catch(ClassNotFoundException e)
		{
				e.printStackTrace();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
