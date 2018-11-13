package com.xeno.shoporganizer.venderdata.resource;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.xeno.shoporganizer.common.OrderUtil;
import com.xeno.shoporganizer.venderdata.model.AmazonReport;
import com.xeno.shoporganizer.venderdata.repository.AmazonReportRepository;
import com.xeno.shoporganizer.venderdata.util.DataParser;

@Path("reports")
public class ReportResource {

private AmazonReportRepository amazonReportRepo = new AmazonReportRepository();
	
	@GET
	@Path("/process-report")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<AmazonReport> processReport() {
		String uploadedFileLocation = "g://downloads/report.csv";
		
		List<AmazonReport> reports = null;
		try {
			reports = DataParser.parseAmazonData(uploadedFileLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(AmazonReport report: reports) {
			int affectedRows = amazonReportRepo.add(report);
			if(affectedRows > 0) {
				OrderUtil.buildOrderFromAmazonReport(report);
			}
		}
		
		return reports;
	}
}
