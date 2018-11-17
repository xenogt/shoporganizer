package com.xeno.shoporganizer.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.xeno.shoporganizer.model.Payment;
import com.xeno.shoporganizer.repository.PaymentRepository;

@Path("payments")
public class PaymentResource {
	
private PaymentRepository paymentRepo = new PaymentRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Payment> getPayments(){
		return paymentRepo.getPayments();
	}
	
	@POST
	@Path("add")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public boolean add(Payment payment) {
		return paymentRepo.add(payment);
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Payment get(@PathParam("id") int paymentID) {
		return paymentRepo.getById(paymentID);
	}
	
}
