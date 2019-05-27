package com.paf.sellnbuy.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paf.sellnbuy.model.Shipping;
import com.paf.sellnbuy.repository.ShippingRepository;

@Service
public class ShippingDAO {
	
	@Autowired
	ShippingRepository deliveryRepo;
	
	//Save a Delivery
	public Shipping save(Shipping delivery) {
		
		return deliveryRepo.save(delivery);
	}
	
	//Search all Deliveries
	public List<Shipping> findAll() {
		
		return deliveryRepo.findAll();
	}
	
	//Get a Delivery
	public Shipping findOne(int id) {
		
		Optional<Shipping> op = deliveryRepo.findById(id);
		
		if (op.isPresent()) {
			
			return op.get();
			
		} else {

			return null;
			
		}
	}
	
	//Delete a Delivery
	public void delete(int id) {
		
		Shipping delivery = deliveryRepo.getOne(id);
		Optional<Shipping> op = deliveryRepo.findById(id);
		
		if (op.isPresent()) {
			
			deliveryRepo.delete(delivery);
			
		} else {

			return;
			
		}
		
		
	}
	
	//Update a Delivery
	public Shipping update(Shipping delivery) {
		
		return deliveryRepo.save(delivery);
		
	}
}
