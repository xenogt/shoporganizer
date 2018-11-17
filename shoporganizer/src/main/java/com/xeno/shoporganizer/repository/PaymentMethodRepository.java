package com.xeno.shoporganizer.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xeno.shoporganizer.common.DBConnection;
import com.xeno.shoporganizer.model.PaymentMethod;

public class PaymentMethodRepository {
	DBConnection dbConnection;
	private static final String TABLE_NAME = "PAYMENT_METHOD";
	private static final String INSERT_STATEMENT = 
			"insert into PAYMENT_METHOD ("
			+ "FINANCIAL_INSTITUTE, "
			+ "ACCOUNT_NUMBER, "
			+ "NOTES"
			+ ") values ( ?, ?, ?);";

	public PaymentMethodRepository() {
		super();
		dbConnection = new DBConnection();
	}
	
	public List<PaymentMethod> paymentMethods() {
		
		List<PaymentMethod> paymentMethods = new ArrayList<>();
		try (ResultSet rs = dbConnection.getAll(TABLE_NAME)) {
			while(rs.next()) {
				PaymentMethod paymentMethod = new PaymentMethod();
				paymentMethod.setPaymentMethodID(rs.getInt(1));
				paymentMethod.setFinancialInstitude(rs.getString(2));
				paymentMethod.setAcctNum(rs.getString(3));
				paymentMethod.setNotes(rs.getString(4));
				paymentMethods.add(paymentMethod);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return paymentMethods;
	}
	
	public PaymentMethod getById(int id) {
		
		PaymentMethod paymentMethod = new PaymentMethod();
		String col = "payment_id";
		
		try (ResultSet rs = dbConnection.getById(TABLE_NAME, col, id)) {
			if(rs.next()) {
				paymentMethod.setPaymentMethodID(rs.getInt(1));
				paymentMethod.setFinancialInstitude(rs.getString(2));
				paymentMethod.setAcctNum(rs.getString(3));
				paymentMethod.setNotes(rs.getString(4));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return paymentMethod;
	}
	
	public PaymentMethod getByKeyValuePair(String key, String value) {
		
		PaymentMethod paymentMethod = new PaymentMethod();
		
		try (ResultSet rs = dbConnection.getById(TABLE_NAME, key, value)) {
			
			if(rs.next()) {
				paymentMethod.setPaymentMethodID(rs.getInt(1));
				paymentMethod.setFinancialInstitude(rs.getString(2));
				paymentMethod.setAcctNum(rs.getString(3));
				paymentMethod.setNotes(rs.getString(4));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return paymentMethod;
	}
	
	public boolean add(PaymentMethod paymentMethod) {
		
		boolean addSuccess = false;
		PreparedStatement st;
		
		try (Connection conn = dbConnection.getConnection()) {
			
			st = conn.prepareStatement(INSERT_STATEMENT, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, paymentMethod.getFinancialInstitude());
			st.setString(2, paymentMethod.getAcctNum());
			st.setString(3, paymentMethod.getNotes());
			st.executeQuery();
			addSuccess = true;
			
		}catch(SQLException e) {
			
		}
		return addSuccess;
	}
}
