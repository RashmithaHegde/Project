package com.app.SpringBootProject.GuestController;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.SpringBootProject.bean.Dining;
import com.app.SpringBootProject.bean.ErrorResponse;
import com.app.SpringBootProject.service.IDiningService;

/**
 * The Class DiningController.
 */
@RestController
@CrossOrigin(origins = "*")
public class DiningController {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(DiningController.class);

	/** The service. */
	@Autowired
	IDiningService service;

	/**
	 * Register.
	 *
	 * @param guestId
	 *            the guest id
	 * @param dining
	 *            the dining
	 * @return the response entity
	 */
	@PostMapping("/dining/register/{guestId}")
	public ResponseEntity<Object> register(@Valid @PathVariable long guestId, @RequestBody Dining dining) {
		ErrorResponse errorResponse = new ErrorResponse();
		LOGGER.info("Entering into /dining/register/{guestId}");
		Dining dining1 = service.registerDining(dining, guestId);

		if (dining1 != null) {
			LOGGER.info("Dining registration successfull......");
			return new ResponseEntity<Object>(dining1, HttpStatus.CREATED);
		}
		LOGGER.error("Registration Failed......Try again");
		errorResponse.setErrorMessage("Something went wrong......Unable to book dining");
		return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Update dining.
	 *
	 * @param dReservationNumber
	 *            the d reservation number
	 * @param dining
	 *            the dining
	 * @return the response entity
	 */
	@PutMapping("/dining/update/{dReservationNumber}")
	public ResponseEntity<Object> updateDining(@PathVariable long dReservationNumber, @RequestBody Dining dining) {
		ErrorResponse errorResponse = new ErrorResponse();
		LOGGER.info("Entering into /dining/update/{dReservationNumber}");
		long status = 0;
		status = service.updateDining(dining, dReservationNumber);
		Dining dining1 = service.getDining(dReservationNumber);

		if (status != 0) {
			LOGGER.info("Dining updated successfully......");
			return new ResponseEntity<Object>(dining1, HttpStatus.CREATED);
		}
		LOGGER.error("Updation Failed......Try again");
		errorResponse.setErrorMessage("Unable to update dining");
		return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);

	}

	/**
	 * Gets the dining.
	 *
	 * @param dReservationNumber
	 *            the d reservation number
	 * @return the dining
	 */
	@GetMapping("/dining/get/{dReservationNumber}")
	public ResponseEntity<Object> getDining(@PathVariable long dReservationNumber) {
		ErrorResponse errorResponse = new ErrorResponse();
		LOGGER.info("Entering into /dining/get/{dReservationNumber}");
		Dining dining;

		dining = service.getDining(dReservationNumber);
		if (dining != null) {
			LOGGER.info("Retrieved Dining information successfull......");
			return new ResponseEntity<Object>(dining, HttpStatus.CREATED);
		}
		LOGGER.error("Retrieving Dining information Failed......Try again");
		errorResponse.setErrorMessage("Unable to get dining information");
		return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Gets the all dining.
	 *
	 * @param guestId
	 *            the guest id
	 * @return the all dining
	 */
	@GetMapping("/dining/getall/{guestId}")
	public List<Dining> getAllDining(@PathVariable long guestId) {
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

	/**
	 * Cancel dining.
	 *
	 * @param dReservationNumber
	 *            the d reservation number
	 * @return the response entity
	 */
	@PutMapping("/dining/cancel/{dReservationNumber}")
	public ResponseEntity<Dining> cancelDining(@PathVariable long dReservationNumber) {
		LOGGER.info("Entering into /dining/cancel/{dReservationNumber}");
		long success = 0;
		success = service.cancelDining(dReservationNumber);

		if (success > 0) {
			LOGGER.info("Dining information deleted successfully......");
			return new ResponseEntity<Dining>(HttpStatus.CREATED);
		} else {
			LOGGER.error("Failed to delete Dining information......");
			return new ResponseEntity<Dining>(HttpStatus.BAD_REQUEST);
		}

	}

}
