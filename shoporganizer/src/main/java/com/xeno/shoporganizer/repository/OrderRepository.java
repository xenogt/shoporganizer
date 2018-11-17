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
	
	public List<Object> getOrderToDisplay(){
		List<Object> orders = new ArrayList<>();
		
		String sql = "select "
					+ "s.shop_name, "
					+ "o.order_date, "
					+ "o.order_number, "
					+ "p.pay_on_date, "
					+ "pm.financial_institute, "
					+ "pm.account_number "
				+ "from orders o, "
					+ "payment p, "
					+ "payment_method pm, "
					+ "shop_account s "
				+ "where o.payment_id=p.payment_id "
				+ "and p.payment_method_id=pm.payment_method_id "
				+ "and o.shop_id=s.shop_id;";
		
		try (Connection conn = dbConnection.getConnection()){
			Statement st = conn.createStatement();
			try (ResultSet rs = st.executeQuery(sql)) {
				while(rs.next()) {
					
				}
			}
		} catch (SQLException e) {
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
		
		PreparedStatement st;
		int affectedRows = 0;
		
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
			affectedRows = st.executeUpdate();

	        if (affectedRows == 0) {
	            throw new SQLException("Creating order failed, no rows affected.");
	        }

	        try (ResultSet generatedKeys = st.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                order.setOrderID(generatedKeys.getInt(1));
	            }
	            else {
	                throw new SQLException("Creating order failed, no ID obtained.");
	            }
	        }
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return affectedRows == 0? false: true;
	}
	
}
