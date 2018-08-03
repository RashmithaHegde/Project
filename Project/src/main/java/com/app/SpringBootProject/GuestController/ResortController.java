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

import com.app.SpringBootProject.bean.Resort;
import com.app.SpringBootProject.service.IResortService;

@RestController

public class ResortController {
	
	private static final Logger LOGGER = LogManager.getLogger(ResortController.class);
	
	@Autowired
	IResortService service;
	
	@PostMapping("/resort/register/{guestId}")
	public ResponseEntity<Resort> register(@PathVariable long guestId, @RequestBody Resort resort)
	{
		LOGGER.info("Entering into /resort/register/{guestId}");
		Resort resort1=service.registerResort(resort,guestId);
		if(resort1!=null)
		{
			LOGGER.info("Resort registration successfull......");
			return new ResponseEntity<Resort>(resort1,HttpStatus.CREATED);
		}
		LOGGER.error("Registration Failed......Try again");
		return new ResponseEntity<Resort>(HttpStatus.BAD_REQUEST);
	}
	
	
	
	
 
	@PutMapping("/resort/update/{rReservationNumber}")
	public ResponseEntity<Resort> updateResort(@PathVariable long rReservationNumber  ,@RequestBody Resort resort)
	{
		LOGGER.info("Entering into /resort/update/{rReservationNumber}");
		long status=0;
		
			status=service.updateResort(resort,rReservationNumber);
			
			Resort resort1=service.getResort(rReservationNumber);
		if(status>0)
		{
			LOGGER.info("Resort updated successfully......");
			return new ResponseEntity<Resort>(resort1, HttpStatus.CREATED);
		}
		LOGGER.error("Updation Failed......Try again");
		return new ResponseEntity<Resort>(HttpStatus.BAD_REQUEST);
		
		
	}
	
	@GetMapping("/resort/get/{rReservationNumber}")
	public ResponseEntity<Resort> getResort(@PathVariable long rReservationNumber )
	{
		LOGGER.info("Entering into /resort/get/{rReservationNumber}");
		Resort resort=service.getResort(rReservationNumber);
		if(resort!=null)
		{
			LOGGER.info("Retrieved Resort information successfull......");
			return new ResponseEntity<Resort>(resort,HttpStatus.CREATED);
		}
		LOGGER.error("Retrieving Resort information Failed......Try again");
		return new ResponseEntity<Resort>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/resort/getall/{guestId}")
	public List<Resort> getAllResort(@PathVariable long guestId )
	{
		LOGGER.info("Entering into /resort/getall/{guestId}");
		List<Resort> resort=service.getAllResort(guestId);
		return resort;
	}
	
	@PutMapping("/resort/cancel/{rReservationNumber}")
	public ResponseEntity<Resort> cancelResort(@PathVariable long rReservationNumber)
	{
		LOGGER.info("Entering into /resort/cancel/{rReservationNumber}");
		long success=0;
		success=service.cancelResort(rReservationNumber);
		
		if(success>0)
		{
			LOGGER.info("Resort information deleted successfully......");
			return new ResponseEntity<Resort>( HttpStatus.CREATED);
		}
		else
		{
			LOGGER.error("Failed to delete Resort information......");
			return new ResponseEntity<Resort>(HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
}
