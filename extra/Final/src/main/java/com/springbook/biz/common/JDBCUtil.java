package com.springbook.biz.common;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	
	public static Connection getConnection() {
		String url = "";
		String user = "";
		String password = "";
		String driver = "";
		try {
			File file = new File("C:\\springWorkspace\\Final\\src\\main\\resources\\config\\dbconnection.properties");
			FileInputStream fis = new FileInputStream(file);
			Properties props = new Properties();
			props.load(fis);
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
			driver = props.getProperty("driver");
			Class.forName(driver);
			return DriverManager.getConnection(url,user,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(Statement stmt,Connection con) {
		if(stmt!=null) {
			try {
				if(stmt.isClosed())stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				stmt = null;
			}
		}
		
		if(con!=null) {
			try {
				if(con.isClosed())con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				con = null;
			}
		}
	}
	
	public static void close(ResultSet rs,Statement stmt,Connection con) {
		if(stmt!=null) {
			try {
				if(stmt.isClosed())stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				stmt = null;
			}
		}
		
		if(con!=null) {
			try {
				if(con.isClosed())con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				con = null;
			}
		}
		
		if(rs!=null) {
			try {
				if(rs.isClosed())rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				rs = null;
			}
		}
	}
}