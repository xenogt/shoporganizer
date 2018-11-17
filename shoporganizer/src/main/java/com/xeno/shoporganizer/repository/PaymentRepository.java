package com.xeno.shoporganizer.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.mariadb.jdbc.internal.com.read.resultset.SelectResultSet;

import com.xeno.shoporganizer.common.DBConnection;
import com.xeno.shoporganizer.model.Payment;

public class PaymentRepository {
	DBConnection dbConnection;
	private static final String TABLE_NAME = "PAYMENT";
	private static final String INSERT_STATEMENT = 
			"insert into PAYMENT ("
			+ "PAYMENT_METHOD_ID, "
			+ "PAY_ON_DATE, "
			+ "CONFIRMATION, "
			+ "NOTES"
			+ ") values ( ?, ?, ?, ?);";

	public PaymentRepository() {
		super();
		dbConnection = new DBConnection();
	}
	
	public List<Payment> getPayments() {
		
		List<Payment> payments = new ArrayList<>();
		
		try (ResultSet rs = dbConnection.getAll(TABLE_NAME)) {
			
			while(rs.next()) {
				Payment payment = new Payment();
				payment.setPaymentID(rs.getInt(1));
				payment.setPaymentMethodID(rs.getInt(2));
				payment.setPayOnDate(rs.getDate(3)==null? null:rs.getDate(3).toLocalDate());
				payment.setConfirmation(rs.getString(4));
				payment.setNotes(rs.getString(5));
				payments.add(payment);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return payments;
	}
	
	public Payment getById(int id) {
		
		Payment payment = new Payment();
		String col = "payment_id";
		
		try (ResultSet rs = dbConnection.getById(TABLE_NAME, col, id)) {
			
			if(rs.next()) {
				payment.setPaymentID(rs.getInt(1));
				payment.setPaymentMethodID(rs.getInt(2));
				payment.setPayOnDate(rs.getDate(3)==null? null:rs.getDate(3).toLocalDate());
				payment.setConfirmation(rs.getString(4));
				payment.setNotes(rs.getString(5));
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return payment;
	}
	
	public boolean add(Payment payment) {
		
		PreparedStatement st;
		int affectedRows = 0;
		
		try (Connection conn = dbConnection.getConnection()) {
			
			st = conn.prepareStatement(INSERT_STATEMENT, Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, payment.getPaymentMethodID());
			st.setDate(2, payment.getPayOnDate()==null?null:Date.valueOf(payment.getPayOnDate()));
			st.setString(3, payment.getConfirmation());
			st.setString(4, payment.getNotes());
			affectedRows = st.executeUpdate();

	        if (affectedRows == 0) {
	            throw new SQLException("Creating payment failed, no rows affected.");
	        }

	        try (ResultSet generatedKeys = st.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                payment.setPaymentID(generatedKeys.getInt(1));
	            }
	            else {
	                throw new SQLException("Creating payment failed, no ID obtained.");
	            }
	        }
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return affectedRows == 0 ? false : true;
	}
}
