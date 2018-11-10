package com.xeno.shoporganizer.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.xeno.shoporganizer.model.Item;
import com.xeno.shoporganizer.repository.ItemRepository;

public class ItemResource {
	
	ItemRepository itemRepo = new ItemRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Item> getItems(){
		return itemRepo.getItems();
	}
	
	@POST
	@Path("add")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public boolean add(Item item) {
		return itemRepo.add(item);
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Item get(@PathParam("id") int itemID) {
		return itemRepo.getById(itemID);
	}
	
}
