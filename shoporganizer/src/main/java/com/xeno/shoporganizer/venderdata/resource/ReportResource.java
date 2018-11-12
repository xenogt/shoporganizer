package com.xeno.shoporganizer.venderdata.resource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.xeno.shoporganizer.model.Email;
import com.xeno.shoporganizer.model.Item;
import com.xeno.shoporganizer.repository.EmailRepository;
import com.xeno.shoporganizer.venderdata.model.AmazonReport;
import com.xeno.shoporganizer.venderdata.repository.AmazonReportRepository;
import com.xeno.shoporganizer.venderdata.util.DataParser;

@Path("reports")
public class ReportResource {

private AmazonReportRepository amazonReportRepo;
	
//	@POST
//	@Path("/upload")
//	@Consumes(MediaType.MULTIPART_FORM_DATA)
//	public Response uploadFile(
//		@FormDataParam("file") InputStream uploadedInputStream,
//		@FormDataParam("file") FormDataContentDisposition fileDetail) {
//	
		
//		String uploadedFileLocation = "g://uploaded/" + fileDetail.getFileName();
//	
//		// save it
//		writeToFile(uploadedInputStream, uploadedFileLocation);
//	
//		String output = "File uploaded to : " + uploadedFileLocation;
	
//		return Response.status(200).entity(output).build();
//		return null;
//	
//	}
//	
//	// save uploaded file to new location
//	private void writeToFile(InputStream uploadedInputStream,
//		String uploadedFileLocation) {
//	
//		try {
//			OutputStream out = new FileOutputStream(new File(
//					uploadedFileLocation));
//			int read = 0;
//			byte[] bytes = new byte[1024];
//	
//			out = new FileOutputStream(new File(uploadedFileLocation));
//			while ((read = uploadedInputStream.read(bytes)) != -1) {
//				out.write(bytes, 0, read);
//			}
//			out.flush();
//			out.close();
//		} catch (IOException e) {
//	
//			e.printStackTrace();
//		}
//	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<AmazonReport> getEmails() throws IOException{
		System.out.println("OMG");
		String uploadedFileLocation = "g://downloads/01-Jan-2018_to_10-Nov-2018.csv";
		return DataParser.parseAmazonData(uploadedFileLocation);
	}
}
