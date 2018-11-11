package com.xeno.shoporganizer.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	private Connection connection;
	String user = "devuser";
	String password = "devpass";
	String dbUrl = "jdbc:mariadb://localhost:3306/shoptracker";
	
	private static final String SQL_GET_ALL = "SELECT * FROM ";
	
	public DBConnection() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
//			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/shop_organizer?user=devuser&password=devuser");
	}
	
	public Connection getConnection() {
		try {
			connection = DriverManager.getConnection(dbUrl, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public ResultSet getAll(String tableName) {
		
		ResultSet rs = null;
		try (Connection conn = this.getConnection()){
			Statement st = connection.createStatement();
			rs = st.executeQuery(SQL_GET_ALL+tableName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet getById(String tableName, String col, int value) {
		
		String sql = "SELECT * FROM "+tableName+" where "+col+" = "+value+";";
		
		ResultSet rs = null;
		try (Connection conn = this.getConnection()){
			Statement st = connection.createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet getById(String tableName, String col, String value) {
		
		String sql = "SELECT * FROM "+tableName+" where "+col+" = "+value+";";
		
		ResultSet rs = null;
		try (Connection conn = this.getConnection()){
			Statement st = connection.createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
