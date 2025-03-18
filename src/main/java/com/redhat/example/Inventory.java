package com.redhat.example;

import java.util.HashMap;
import java.util.Map;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/inventory")
public class Inventory {
    private Map<String, Item> repository = new HashMap<>();

    public Inventory() {
        Item[] items = {
                new Item("1001", "Laptop", 10),
                new Item("1002", "Smartphone", 50),
                new Item("1003", "Headphones", 100),
                new Item("2001", "T-Shirt", 200),
                new Item("2002", "Jeans", 150)
        };
        for (Item item : items) {
            repository.put(item.getItemId(), item);
        }
    }

    @GET
    @Path("available/{item-id}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public boolean checkAvailability(@PathParam("item-id") String itemId) {
        Item item = repository.get(itemId);
        boolean available = item != null && item.getQuantity() > 0;
        System.out.println("Inventory checkAvailability for item: " + itemId + " result: " + available);
        return available;
    }

    @GET
    @Path("{item-id}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Item findById(@PathParam("item-id") String itemId) {
        Item item = repository.get(itemId);
        System.out.println("Inventory findById: " + itemId);
        return item;
    }
}
