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
import com.xeno.shoporganizer.model.Item;

public class ItemRepository {
	
	DBConnection dbConnection;
	private static final String TABLE_NAME = "ITEMS";
	private static final String INSERT_STATEMENT = 
			"insert into ITEMS ("
			+ "date_received, "
			+ "item_name, "
			+ "cost, "
			+ "description, "
			+ "item_url, "
			+ "order_id, "
			+ "return_requested_date, "
			+ "return_shipped_date, "
			+ "refund_received_date, "
			+ "notes"
			+ ") values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	
	public ItemRepository() {
		
		super();
		dbConnection = new DBConnection();
		
	}
	
	public List<Item> getItems() {
		
		List<Item> items = new ArrayList<>();
		
		try (ResultSet rs = dbConnection.getAll(TABLE_NAME)) {
			
			while(rs.next()) {
				Item item = new Item();
				item.setItemID(rs.getInt(1));
				item.setDateReceived(rs.getDate(2).toLocalDate());
				item.setItemName(rs.getString(3));
				item.setCost(rs.getDouble(4));
				item.setDescription(rs.getString(5));
				item.setItemUrl(rs.getString(6));
				item.setOrderID(rs.getInt(7));
				item.setReturnRequestedDate(rs.getDate(8).toLocalDate());
				item.setReturnShippedDate(rs.getDate(9).toLocalDate());
				item.setRefundReceived(rs.getBoolean(10));
				item.setNotes(rs.getString(11));
				items.add(item);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return items;
	}
	
	public Item getById(int id) {
		
		Item item = new Item();
		String col = "item_id";
		
		try (ResultSet rs = dbConnection.getById(TABLE_NAME, col, id)) {
			
			if(rs.next()) {
				item.setItemID(rs.getInt(1));
				item.setDateReceived(rs.getDate(2).toLocalDate());
				item.setItemName(rs.getString(3));
				item.setCost(rs.getDouble(4));
				item.setDescription(rs.getString(5));
				item.setItemUrl(rs.getString(6));
				item.setOrderID(rs.getInt(7));
				item.setReturnRequestedDate(rs.getDate(8).toLocalDate());
				item.setReturnShippedDate(rs.getDate(9).toLocalDate());
				item.setRefundReceived(rs.getBoolean(10));
				item.setNotes(rs.getString(11));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return item;
	}
	
	public boolean add(Item item) {
		
		boolean addSuccess = false;
		PreparedStatement st;
		
		try (Connection conn = dbConnection.getConnection()) {
			
			st = conn.prepareStatement(INSERT_STATEMENT, Statement.RETURN_GENERATED_KEYS);
			st.setDate(1, Date.valueOf(item.getDateReceived()));
			st.setString(2, item.getItemName());
			st.setDouble(3, item.getCost());
			st.setString(4, item.getDescription());
			st.setString(5, item.getItemUrl());
			st.setInt(6, item.getOrderID());
			st.setDate(7, Date.valueOf(item.getReturnRequestedDate()));
			st.setDate(8, Date.valueOf(item.getReturnShippedDate()));
			st.setBoolean(9, item.isRefundReceived());
			st.setString(10, item.getNotes());
			st.executeQuery();
			addSuccess = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return addSuccess; 
	}
	
}
