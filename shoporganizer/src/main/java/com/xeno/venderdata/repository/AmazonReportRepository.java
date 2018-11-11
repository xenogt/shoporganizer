package com.xeno.venderdata.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.xeno.shoporganizer.common.DBConnection;
import com.xeno.venderdata.model.AmazonReport;

public class AmazonReportRepository {
	
	DBConnection dbConnection;
	private String TABLE_NAME = "AMAZON_REPORT";
	private static final String INSERT_STATEMENT = 
			"insert into AMAZON_REPORT ("
			+ "order_date, "
			+ "order_id, "
			+ "payment_instrument_type, "
			+ "website, "
			+ "purchase_order_number, "
			+ "ordering_customer_email, "
			+ "shipment_date, "
			+ "shipping_address_name, "
			+ "shipping_address_street1, "
			+ "shipping_address_street2, "
			+ "shipping_address_city, "
			+ "shipping_address_state, "
			+ "shipping_address_zip, "
			+ "order_status, "
			+ "carrier_name_and_tracking_number, "
			+ "subtotal, "
			+ "shipping_charge, "
			+ "tax_before_promotions, "
			+ "total_promotions, "
			+ "tax_charged, "
			+ "total_charged, "
			+ "buyer_name, "
			+ "group_name "
			+ ") values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

	public AmazonReportRepository() {
		super();
		dbConnection = new DBConnection();
	}
	
	public List<AmazonReport> getAmazonReports() {
		
		List<AmazonReport> amazonReports = new ArrayList<>();
		
		try (ResultSet rs = dbConnection.getAll(TABLE_NAME)) {
			
			while(rs.next()) {
				AmazonReport amazonReport = new AmazonReport();
				amazonReport.setOrderDate(rs.getDate(1).toLocalDate());
				amazonReport.setOrderID(rs.getString(2));
				amazonReport.setPaymentInstrumentType(rs.getString(3));
				amazonReport.setWebsite(rs.getString(4));
				amazonReport.setPurchaseOrderNumber(rs.getString(5));
				amazonReport.setOrderingCustomerEmail(rs.getString(6));
				amazonReport.setShipmentDate(rs.getDate(7).toLocalDate());
				amazonReport.setShippingAddressName(rs.getString(8));
				amazonReport.setShippingAddressStreet1(rs.getString(9));
				amazonReport.setShippingAddressStreet2(rs.getString(10));
				amazonReport.setShippingAddressCity(rs.getString(11));
				amazonReport.setShippingAddressState(rs.getString(12));
				amazonReport.setShippingAddressZip(rs.getString(13));
				amazonReport.setOrderStatus(rs.getString(14));
				amazonReport.setCarrierNameAndTrackingNumber(rs.getString(15));
				amazonReport.setSubtotal(rs.getDouble(16));
				amazonReport.setShippingCharge(rs.getDouble(17));
				amazonReport.setTaxBeforePromotions(rs.getDouble(18));
				amazonReport.setTotalPromotions(rs.getDouble(19));
				amazonReport.setTaxCharged(rs.getDouble(20));
				amazonReport.setTotalCharged(rs.getDouble(21));
				amazonReport.setBuyerName(rs.getString(22));
				amazonReport.setGroupName(rs.getString(23));
				amazonReports.add(amazonReport);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return amazonReports;
	}
	
	public AmazonReport getById(String id) {
		
		AmazonReport amazonReport = new AmazonReport();
		String col = "report_id";
		
		try (ResultSet rs = dbConnection.getById(TABLE_NAME, col, id)) {
			
			if(rs.next()) {
				amazonReport.setOrderDate(rs.getDate(1).toLocalDate());
				amazonReport.setOrderID(rs.getString(2));
				amazonReport.setPaymentInstrumentType(rs.getString(3));
				amazonReport.setWebsite(rs.getString(4));
				amazonReport.setPurchaseOrderNumber(rs.getString(5));
				amazonReport.setOrderingCustomerEmail(rs.getString(6));
				amazonReport.setShipmentDate(rs.getDate(7).toLocalDate());
				amazonReport.setShippingAddressName(rs.getString(8));
				amazonReport.setShippingAddressStreet1(rs.getString(9));
				amazonReport.setShippingAddressStreet2(rs.getString(10));
				amazonReport.setShippingAddressCity(rs.getString(11));
				amazonReport.setShippingAddressState(rs.getString(12));
				amazonReport.setShippingAddressZip(rs.getString(13));
				amazonReport.setOrderStatus(rs.getString(14));
				amazonReport.setCarrierNameAndTrackingNumber(rs.getString(15));
				amazonReport.setSubtotal(rs.getDouble(16));
				amazonReport.setShippingCharge(rs.getDouble(17));
				amazonReport.setTaxBeforePromotions(rs.getDouble(18));
				amazonReport.setTotalPromotions(rs.getDouble(19));
				amazonReport.setTaxCharged(rs.getDouble(20));
				amazonReport.setTotalCharged(rs.getDouble(21));
				amazonReport.setBuyerName(rs.getString(22));
				amazonReport.setGroupName(rs.getString(23));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return amazonReport;
	}
	
	public AmazonReport getByKeyValuePair(String key, String value) {
		
		AmazonReport amazonReport = new AmazonReport();
		
		try (ResultSet rs = dbConnection.getById(TABLE_NAME, key, value)) {
			
			if(rs.next()) {
				amazonReport.setOrderDate(rs.getDate(1).toLocalDate());
				amazonReport.setOrderID(rs.getString(2));
				amazonReport.setPaymentInstrumentType(rs.getString(3));
				amazonReport.setWebsite(rs.getString(4));
				amazonReport.setPurchaseOrderNumber(rs.getString(5));
				amazonReport.setOrderingCustomerEmail(rs.getString(6));
				amazonReport.setShipmentDate(rs.getDate(7).toLocalDate());
				amazonReport.setShippingAddressName(rs.getString(8));
				amazonReport.setShippingAddressStreet1(rs.getString(9));
				amazonReport.setShippingAddressStreet2(rs.getString(10));
				amazonReport.setShippingAddressCity(rs.getString(11));
				amazonReport.setShippingAddressState(rs.getString(12));
				amazonReport.setShippingAddressZip(rs.getString(13));
				amazonReport.setOrderStatus(rs.getString(14));
				amazonReport.setCarrierNameAndTrackingNumber(rs.getString(15));
				amazonReport.setSubtotal(rs.getDouble(16));
				amazonReport.setShippingCharge(rs.getDouble(17));
				amazonReport.setTaxBeforePromotions(rs.getDouble(18));
				amazonReport.setTotalPromotions(rs.getDouble(19));
				amazonReport.setTaxCharged(rs.getDouble(20));
				amazonReport.setTotalCharged(rs.getDouble(21));
				amazonReport.setBuyerName(rs.getString(22));
				amazonReport.setGroupName(rs.getString(23));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return amazonReport;
	}
	
	public boolean add(AmazonReport amazonReport) {
		
		boolean addSuccess = false;
		PreparedStatement st;
		
		try (Connection conn = dbConnection.getConnection()) {
			
			st = conn.prepareStatement(INSERT_STATEMENT, Statement.RETURN_GENERATED_KEYS);
			st.setDate(1, Date.valueOf(amazonReport.getOrderDate()));
			st.setString(2, amazonReport.getOrderID());
			st.setString(3, amazonReport.getPaymentInstrumentType());
			st.setString(4, amazonReport.getWebsite());
			st.setString(5, amazonReport.getPurchaseOrderNumber());
			st.setString(6, amazonReport.getOrderingCustomerEmail());
			st.setDate(7, Date.valueOf(amazonReport.getShipmentDate()));
			st.setString(8, amazonReport.getShippingAddressName());
			st.setString(9, amazonReport.getShippingAddressStreet1());
			st.setString(10, amazonReport.getShippingAddressStreet2());
			st.setString(11, amazonReport.getShippingAddressCity());
			st.setString(12, amazonReport.getShippingAddressState());
			st.setString(13, amazonReport.getShippingAddressZip());
			st.setString(14, amazonReport.getOrderStatus());
			st.setString(15, amazonReport.getCarrierNameAndTrackingNumber());
			st.setDouble(16, amazonReport.getSubtotal());
			st.setDouble(17, amazonReport.getShippingCharge());
			st.setDouble(18, amazonReport.getTaxBeforePromotions());
			st.setDouble(19, amazonReport.getTotalPromotions());
			st.setDouble(20, amazonReport.getTaxCharged());
			st.setDouble(21, amazonReport.getTotalCharged());
			st.setString(22, amazonReport.getBuyerName());
			st.setString(23, amazonReport.getGroupName());
			ResultSet rs = st.executeQuery();
			addSuccess = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return addSuccess;
	}
}
