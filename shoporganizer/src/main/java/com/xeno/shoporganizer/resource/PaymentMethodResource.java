package com.xeno.shoporganizer.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.xeno.shoporganizer.model.PaymentMethod;
import com.xeno.shoporganizer.repository.PaymentMethodRepository;

@Path("payment-methods")
public class PaymentMethodResource {
	
	private PaymentMethodRepository pmRepo = new PaymentMethodRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<PaymentMethod> getPaymentMethods(){
		return pmRepo.paymentMethods();
	}
	
	@POST
	@Path("add")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public boolean add(PaymentMethod pm) {
		return pmRepo.add(pm);
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public PaymentMethod get(@PathParam("id") int paymentID) {
		return pmRepo.getById(paymentID);
	}
	
}
