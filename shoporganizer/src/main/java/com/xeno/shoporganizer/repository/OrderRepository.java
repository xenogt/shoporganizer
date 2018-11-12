package com.xeno.shoporganizer.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xeno.shoporganizer.common.DBConnection;
import com.xeno.shoporganizer.model.Order;

public class OrderRepository {
	
	private String TABLE_NAME = "ORDERS";
	DBConnection dbConnection;
	private static final String INSERT_STATEMENT = 
			"insert into ORDERS ("
			+ "order_date, "
			+ "order_complete_date, "
			+ "shop_id, "
			+ "payment_id, "
			+ "has_return_item, "
			+ "return_completed, "
			+ "order_number, "
			+ "notes"
			+ ") values ( ?, ?, ?, ?, ?, ?, ?, ?);";

	public OrderRepository() {
		super();
		dbConnection = new DBConnection();
	}
	
	public List<Order> getOrders() {
		
		List<Order> orders = new ArrayList<>();
		
		try (ResultSet rs = dbConnection.getAll(TABLE_NAME)) {
			
			while(rs.next()) {
				Order order = new Order();
				order.setOrderID(rs.getInt(1));
				order.setOrderDate(rs.getDate(2)==null? null:rs.getDate(2).toLocalDate());
				order.setOrderCompleteDate(rs.getDate(3)==null? null:rs.getDate(3).toLocalDate());
				order.setShopID(rs.getInt(4));
				order.setPaymentID(rs.getInt(5));
				order.setHasReturnItem(rs.getBoolean(6));
				order.setReturnCompleted(rs.getBoolean(7));
				order.setOrderNumber(rs.getString(8));
				order.setNotes(rs.getString(9));
				orders.add(order);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}
	
	public Order getById(int id) {
		
		Order order = new Order();
		String col = "order_id";
		
		try (ResultSet rs = dbConnection.getById(TABLE_NAME, col, id)) {
			
			if(rs.next()) {
				order.setOrderID(rs.getInt(1));
				order.setOrderDate(rs.getDate(2)==null? null:rs.getDate(2).toLocalDate());
				order.setOrderCompleteDate(rs.getDate(3)==null? null:rs.getDate(3).toLocalDate());
				order.setShopID(rs.getInt(4));
				order.setPaymentID(rs.getInt(5));
				order.setHasReturnItem(rs.getBoolean(6));
				order.setReturnCompleted(rs.getBoolean(7));
				order.setOrderNumber(rs.getString(8));
				order.setNotes(rs.getString(9));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return order;
	}
	
	public boolean add(Order order) {
		
		boolean addSuccess = false;
		PreparedStatement st;
		
		try (Connection conn = dbConnection.getConnection()) {
			
			st = conn.prepareStatement(INSERT_STATEMENT, Statement.RETURN_GENERATED_KEYS);
			st.setDate(1, order.getOrderDate()==null?null:Date.valueOf(order.getOrderDate()));
			st.setDate(2, order.getOrderCompleteDate()==null?null:Date.valueOf(order.getOrderCompleteDate()));
			st.setInt(3, order.getShopID());
			st.setInt(4, order.getPaymentID());
			st.setBoolean(5, order.isHasReturnItem());
			st.setBoolean(6,  order.isReturnCompleted());
			st.setString(7, order.getOrderNumber());
			st.setString(8, order.getNotes());
			st.executeQuery();
			addSuccess = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return addSuccess;
	}
	
}
