package com.xeno.shoporganizer.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xeno.shoporganizer.common.DBConnection;
import com.xeno.shoporganizer.model.Email;

public class EmailRepository {
	
	DBConnection dbConnection;
	private static final String TABLE_NAME = "EMAILS";
	private static final String INSERT_STATEMENT = "insert into emails (email_address, password, registered_date) values ( ?, ?, ?);";
	
	public EmailRepository() {
		super();
		dbConnection = new DBConnection();
	}

	public List<Email> getEmails(){
		
		List<Email> emails = new ArrayList<>();
		
		try (ResultSet rs = dbConnection.getAll(TABLE_NAME)) {
			while(rs.next()) {
				Email email = new Email();
				email.setEmailID(rs.getInt(1));
				email.setEmailAddress(rs.getString(2));
				email.setPword(rs.getString(3));
				email.setRegisteredDate(rs.getDate(4)==null? null: rs.getDate(4).toLocalDate());
				emails.add(email);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emails;
	}
	
	public Email getEmail(int id) {
		
		Email email = new Email();
		String col = "email_id";
		
		try (ResultSet rs = dbConnection.getById(TABLE_NAME, col, id)){
			if(rs.next()) {
				email.setEmailID(rs.getInt(1));
				email.setEmailAddress(rs.getString(2));
				email.setPword(rs.getString(3));
				email.setRegisteredDate(rs.getDate(4)==null? null:rs.getDate(4).toLocalDate());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return email;
	}
	
	public boolean add(Email email) {
		
		boolean returnVal = false;
		PreparedStatement st;
		try (Connection conn = dbConnection.getConnection()){
			st = conn.prepareStatement(INSERT_STATEMENT, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, email.getEmailAddress());
			st.setString(2, email.getPword());
			st.setDate(3, email.getRegisteredDate() == null ? null : Date.valueOf(email.getRegisteredDate()));
			
			st.executeQuery();
			returnVal = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return returnVal;
	}
	
}
