package com.xeno.venderdata.util;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.xeno.venderdata.enums.EnumAmazonReportHeaders;
import com.xeno.venderdata.model.AmazonReport;

public class DataParser {
	
	public static List<AmazonReport> parseAmazonData() throws IOException {
		
		List<AmazonReport> reportList = new ArrayList<>();
		EnumAmazonReportHeaders[] headerList = EnumAmazonReportHeaders.values(); 
		
		try (
				Reader reader = Files.newBufferedReader(Paths.get("")); 
				CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT
						.withHeader(EnumAmazonReportHeaders.class)
						.withIgnoreHeaderCase()
						.withTrim());
			) {
			
			for (CSVRecord record: parser) {
				
				int counter = 0;
				AmazonReport report = new AmazonReport();
				//record.get(headerList[counter++].getHeaderText()) gets the header text for the column and maps the value
				report.setOrderDate(LocalDate.parse(record.get(headerList[counter++].getHeaderText())));
				report.setOrderID(record.get(headerList[counter++].getHeaderText()));
				report.setPaymentInstrumentType(record.get(headerList[counter++].getHeaderText()));
				report.setWebsite(record.get(headerList[counter++].getHeaderText()));
				report.setPurchaseOrderNumber(record.get(headerList[counter++].getHeaderText()));
				report.setOrderingCustomerEmail(record.get(headerList[counter++].getHeaderText()));
				report.setShipmentDate(LocalDate.parse(record.get(headerList[counter++].getHeaderText())));
				report.setShippingAddressName(record.get(headerList[counter++].getHeaderText()));
				report.setShippingAddressStreet1(record.get(headerList[counter++].getHeaderText()));
				report.setShippingAddressStreet2(record.get(headerList[counter++].getHeaderText()));
				report.setShippingAddressCity(record.get(headerList[counter++].getHeaderText()));
				report.setShippingAddressState(record.get(headerList[counter++].getHeaderText()));
				report.setShippingAddressZip(record.get(headerList[counter++].getHeaderText()));
				report.setOrderStatus(record.get(headerList[counter++].getHeaderText()));
				report.setCarrierNameAndTrackingNumber(record.get(headerList[counter++].getHeaderText()));
				report.setSubtotal(Double.parseDouble(record.get(headerList[counter++].getHeaderText())));
				report.setShippingCharge(Double.parseDouble(record.get(headerList[counter++].getHeaderText())));
				report.setTaxBeforePromotions(Double.parseDouble(record.get(headerList[counter++].getHeaderText())));
				report.setTotalPromotions(Double.parseDouble(record.get(headerList[counter++].getHeaderText())));
				report.setTaxCharged(Double.parseDouble(record.get(headerList[counter++].getHeaderText())));
				report.setTotalCharged(Double.parseDouble(record.get(headerList[counter++].getHeaderText())));
				report.setBuyerName(record.get(headerList[counter++].getHeaderText()));
				report.setGroupName(record.get(headerList[counter].getHeaderText()));
				
				reportList.add(report);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return reportList;
	}
	
}
