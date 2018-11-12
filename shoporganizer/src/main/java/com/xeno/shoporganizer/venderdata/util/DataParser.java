package com.xeno.shoporganizer.venderdata.util;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.xeno.shoporganizer.venderdata.enums.EnumAmazonReportHeaders;
import com.xeno.shoporganizer.venderdata.model.AmazonReport;

public class DataParser {
	
	public static List<AmazonReport> parseAmazonData(String pathToFile) throws IOException {
		
		List<AmazonReport> reportList = new ArrayList<>();
		try (
				Reader reader = Files.newBufferedReader(Paths.get(pathToFile)); 
				CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT
						.withHeader(EnumAmazonReportHeaders.class)
						.withIgnoreHeaderCase()
						.withTrim());
			) {
			
			for (CSVRecord record: parser) {
				
				if(record.getRecordNumber() == 1) 
					continue;
				
				AmazonReport report = new AmazonReport();
				report.setOrderDate(formatDate(record.get(EnumAmazonReportHeaders.orderDate)));
				report.setOrderID(record.get(EnumAmazonReportHeaders.orderID));
				report.setPaymentInstrumentType(record.get(EnumAmazonReportHeaders.paymentInstrumentType));
				report.setWebsite(record.get(EnumAmazonReportHeaders.website));
				report.setPurchaseOrderNumber(record.get(EnumAmazonReportHeaders.purchaseOrderNumber));
				report.setOrderingCustomerEmail(record.get(EnumAmazonReportHeaders.orderingCustomerEmail));
				report.setShipmentDate(formatDate(record.get(EnumAmazonReportHeaders.shipmentDate)));
				report.setShippingAddressName(record.get(EnumAmazonReportHeaders.shippingAddressName));
				report.setShippingAddressStreet1(record.get(EnumAmazonReportHeaders.shippingAddressStreet1));
				report.setShippingAddressStreet2(record.get(EnumAmazonReportHeaders.shippingAddressStreet2));
				report.setShippingAddressCity(record.get(EnumAmazonReportHeaders.shippingAddressCity));
				report.setShippingAddressState(record.get(EnumAmazonReportHeaders.shippingAddressState));
				report.setShippingAddressZip(record.get(EnumAmazonReportHeaders.shippingAddressZip));
				report.setOrderStatus(record.get(EnumAmazonReportHeaders.orderStatus));
				report.setCarrierNameAndTrackingNumber(record.get(EnumAmazonReportHeaders.carrierNameAndTrackingNumber));
				report.setSubtotal(Double.parseDouble(record.get(EnumAmazonReportHeaders.subtotal).substring(1)));
				report.setShippingCharge(Double.parseDouble(record.get(EnumAmazonReportHeaders.shippingCharge).substring(1)));
				report.setTaxBeforePromotions(Double.parseDouble(record.get(EnumAmazonReportHeaders.taxBeforePromotions).substring(1)));
				report.setTotalPromotions(Double.parseDouble(record.get(EnumAmazonReportHeaders.totalPromotions).substring(1)));
				report.setTaxCharged(Double.parseDouble(record.get(EnumAmazonReportHeaders.taxCharged).substring(1)));
				report.setTotalCharged(Double.parseDouble(record.get(EnumAmazonReportHeaders.totalCharged).substring(1)));
				report.setBuyerName(record.get(EnumAmazonReportHeaders.buyerName));
				report.setGroupName(record.get(EnumAmazonReportHeaders.groupName));
				
				reportList.add(report);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return reportList;
	}
	
	public static LocalDate formatDate(CharSequence date) {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/[uuuu][uu]");
	    return LocalDate.parse(date, formatter);
	}
}
