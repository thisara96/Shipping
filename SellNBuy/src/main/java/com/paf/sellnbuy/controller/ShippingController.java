package com.paf.sellnbuy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paf.sellnbuy.dao.ShippingDAO;
import com.paf.sellnbuy.model.Shipping;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/deliveries")
public class ShippingController {

	@Autowired
	ShippingDAO deliveryDAO;
	
	//Get all Deliveries
	@GetMapping("/delivery")
	public List<Shipping> getDelivery() {
		
		return deliveryDAO.findAll();
	}
	
	//Add a Delivery
	@PostMapping("/delivery")
	public Shipping addDelivery(@RequestBody Shipping delivery) {
		
		return deliveryDAO.save(delivery);
	}
	
	//Get a Delivery
	@GetMapping("/delivery/{id}")
	public Shipping getDelivery(@PathVariable("id") int pid) {
		
		return deliveryDAO.findOne(pid);
	}
	
	//Delete a Delivery
	@DeleteMapping("/delivery/{id}")
	public void deleteDelivery(@PathVariable("id") int pid) {
		
		deliveryDAO.delete(pid);
		
	}
	
	//Update a Delivery
	@PutMapping("/delivery")
	public Shipping updateDelivery(@RequestBody Shipping delivery) {

		return deliveryDAO.update(delivery);
	}
	
}
