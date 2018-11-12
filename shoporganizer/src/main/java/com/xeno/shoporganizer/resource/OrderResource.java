package com.xeno.shoporganizer.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.xeno.shoporganizer.model.Order;
import com.xeno.shoporganizer.repository.OrderRepository;

@Path("orders")
public class OrderResource {
	
	private OrderRepository orderRepo;
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Order> getOrders(){
		return orderRepo.getOrders();
	}
	
	@POST
	@Path("add")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public boolean add(Order order) {
		return orderRepo.add(order);
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Order get(@PathParam("id") int orderID) {
		return orderRepo.getById(orderID);
	}
}
