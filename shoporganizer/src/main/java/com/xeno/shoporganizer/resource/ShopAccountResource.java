package com.xeno.shoporganizer.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.xeno.shoporganizer.model.ShopAccount;
import com.xeno.shoporganizer.repository.ShopAccountRepository;

@Path("shops")
public class ShopAccountResource {
	
	private ShopAccountRepository shopRepo = new ShopAccountRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<ShopAccount> getAccounts(){
		return shopRepo.getAccounts();
	}
	
	@POST
	@Path("add")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public boolean add(ShopAccount account) {
		return shopRepo.add(account);
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ShopAccount get(@PathParam("id") int shopID) {
		return shopRepo.getById(shopID);
	}
	
}
