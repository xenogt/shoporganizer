package com.xeno.shoporganizer.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xeno.shoporganizer.common.DBConnection;
import com.xeno.shoporganizer.model.ShopAccount;

public class ShopAccountRepository {
	
	DBConnection dbConnection;
	private static final String TABLE_NAME = "SHOP_ACCOUNT";
	private static final String INSERT_STATEMENT = 
			"insert into SHOP_ACCOUNT ("
			+ "shop_name, "
			+ "registered_id, "
			+ "password, "
			+ "shop_url, "
			+ "registered_date, "
			+ "email_id, "
			+ "phone, "
			+ "address, "
			+ "payment_method_id, "
			+ "notes"
			+ ") values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	
	public ShopAccountRepository() {
		super();
		dbConnection = new DBConnection();
	}
	
	public List<ShopAccount> getAccounts() {
		
		List<ShopAccount> accounts = new ArrayList<>();
		
		try (ResultSet rs = dbConnection.getAll(TABLE_NAME)){
			while(rs.next()) {
				ShopAccount account = new ShopAccount();
				account.setShopID(rs.getInt(1));
				account.setShopName(rs.getString(2));
				account.setRegisteredID(rs.getString(3));
				account.setPassword(rs.getString(4));
				account.setShopURL(rs.getString(5));
				account.setRegisteredDate(rs.getDate(6));
				account.setEmailID(rs.getInt(7));
				account.setPhone(rs.getString(8));
				account.setAddress(rs.getString(9));
				account.setPaymentID(rs.getInt(10));
				account.setNotes(rs.getString(11));
				accounts.add(account);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return accounts;
	}
	
	public ShopAccount get(int id) {
		
		ShopAccount account = new ShopAccount();
		String col = "shop_id";
		
		try (ResultSet rs = dbConnection.getById(TABLE_NAME, col, id)) {
			if(rs.next()) {
				account.setShopID(rs.getInt(1));
				account.setShopName(rs.getString(2));
				account.setRegisteredID(rs.getString(3));
				account.setPassword(rs.getString(4));
				account.setShopURL(rs.getString(5));
				account.setRegisteredDate(rs.getDate(6));
				account.setEmailID(rs.getInt(7));
				account.setPhone(rs.getString(8));
				account.setAddress(rs.getString(9));
				account.setPaymentID(rs.getInt(10));
				account.setNotes(rs.getString(11));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return account;
	}
	
	public boolean add(ShopAccount account) {
		
		boolean addSuccess = false;
		PreparedStatement st;
		try (Connection conn = dbConnection.getConnection()) {
			
			st = conn.prepareStatement(INSERT_STATEMENT, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, account.getShopName());
			st.setString(2, account.getRegisteredID());
			st.setString(3, account.getPassword());
			st.setString(4, account.getShopURL());
			st.setDate(5, account.getRegisteredDate());
			st.setInt(6, account.getEmailID());
			st.setString(7, account.getPhone());
			st.setString(8, account.getAddress());
			st.setInt(9, account.getPaymentID());
			st.setString(10, account.getNotes());
			st.executeQuery();
			addSuccess = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return addSuccess;
	}
}
