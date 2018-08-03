package com.app.SpringBootProject.GuestController;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.SpringBootProject.bean.Dining;
import com.app.SpringBootProject.service.IDiningService;

@RestController
public class DiningController {
	
	private static final Logger LOGGER = LogManager.getLogger(DiningController.class);
	
	@Autowired
	IDiningService service;
	
	@PostMapping("/dining/register/{guestId}")
	public ResponseEntity<Dining> register(@PathVariable long guestId,@RequestBody Dining dining)
	{
		LOGGER.info("Entering into /dining/register/{guestId}");
		Dining dining1 = service.registerDining(dining,guestId);
		
		if(dining1!=null)
		{
			LOGGER.info("Dining registration successfull......");
			return new ResponseEntity<Dining>(dining1, HttpStatus.CREATED);
		}
		LOGGER.error("Registration Failed......Try again");
		return new ResponseEntity<Dining>(HttpStatus.BAD_REQUEST);
	}
 
	@PutMapping("/dining/update/{dReservationNumber}")
	public ResponseEntity<Dining> updateDining(@PathVariable long dReservationNumber,@RequestBody Dining dining)
	{
		LOGGER.info("Entering into /dining/update/{dReservationNumber}");
		long status=0;
		
		
			status = service.updateDining(dining, dReservationNumber);
			Dining dining1=service.getDining(dReservationNumber);
		
			if(status!=0)
			{
			LOGGER.info("Dining updated successfully......");
				return new ResponseEntity<Dining>(dining1, HttpStatus.CREATED);
			}
		LOGGER.error("Updation Failed......Try again");
			return new ResponseEntity<Dining>(HttpStatus.BAD_REQUEST);
		
		
	}
	
	@GetMapping("/dining/get/{dReservationNumber}")
	public ResponseEntity<Dining> getDining(@PathVariable long dReservationNumber )
	{
		LOGGER.info("Entering into /dining/get/{dReservationNumber}");
		Dining dining;
		
			dining = service.getDining(dReservationNumber);
			if(dining!=null)
			{
			LOGGER.info("Retrieved Dining information successfull......");
				return new ResponseEntity<Dining>(dining,HttpStatus.CREATED);
			}
		LOGGER.error("Retrieving Dining information Failed......Try again");
			return new ResponseEntity<Dining>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/dining/getall/{guestId}")
	public List<Dining> getAllDining(@PathVariable long guestId )
	{
		LOGGER.info("Entering into /dining/getall/{guestId}");
		List<Dining> dining;
		try {
			dining = service.getAllDining(guestId);
		} catch (Exception e) {
			LOGGER.error("Failed to fetch Dining information......");
			return null;
		}
		return dining;
	}
	
	@PutMapping("/dining/cancel/{dReservationNumber}")
	public ResponseEntity<Dining> cancelDining(@PathVariable long dReservationNumber)
	{
		LOGGER.info("Entering into /dining/cancel/{dReservationNumber}");
		long success=0;
		success=service.cancelDining(dReservationNumber);
		

		if(success>0)
		{
			LOGGER.info("Dining information deleted successfully......");
			return new ResponseEntity<Dining>( HttpStatus.CREATED);
		}
		else
		{
			LOGGER.error("Failed to delete Dining information......");
			return new ResponseEntity<Dining>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	

}
