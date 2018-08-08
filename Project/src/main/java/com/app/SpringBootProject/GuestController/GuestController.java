package com.app.SpringBootProject.GuestController;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.SpringBootProject.bean.Dining;
import com.app.SpringBootProject.bean.ErrorResponse;
import com.app.SpringBootProject.bean.Guest;
import com.app.SpringBootProject.bean.Resort;
import com.app.SpringBootProject.service.IDiningService;
import com.app.SpringBootProject.service.IGuestService;
import com.app.SpringBootProject.service.IResortService;
import com.app.SpringBootProject.validator.GuestValidator;

/**
 * The Class GuestController.
 */
@RestController
@CrossOrigin(origins = "*")
public class GuestController {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(GuestController.class);

	/** The service. */
	@Autowired
	IGuestService service;

	/** The dining service. */
	@Autowired
	IDiningService diningService;

	/** The resort service. */
	@Autowired
	IResortService resortService;

	/** The guest validator. */
	@Autowired
	private GuestValidator guestValidator;

	/**
	 * Inits the binder.
	 *
	 * @param binder
	 *            the binder
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(guestValidator);
	}

	/**
	 * Login.
	 *
	 * @param guest
	 *            the guest
	 * @return the response entity
	 */
	@PostMapping("/guest/login")
	public ResponseEntity<Object> login(@RequestBody Guest guest) {

		ErrorResponse errorResponse = new ErrorResponse();
		LOGGER.info("Entering into /guest/login");

		Guest guest1 = service.validate(guest.getEmail(), guest.getPassword());

		if (guest1 == null) {

			LOGGER.error("Login Failed......Try again");
			errorResponse.setErrorMessage("Something went wrong......Couldn't login");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.NOT_FOUND);

		}

		LOGGER.info("Successfully logged in");
		return new ResponseEntity<Object>(guest1, HttpStatus.ACCEPTED);

	}

	/**
	 * Register.
	 *
	 * @param guest
	 *            the guest
	 * @return the response entity
	 */
	@PostMapping("/guest/register")
	public ResponseEntity<Object> register(@RequestBody @Validated Guest guest) {

		ErrorResponse errorResponse = new ErrorResponse();
		LOGGER.info("Entering into /guest/register");

		Guest guest1 = service.registerGuest(guest);
		if (guest1 != null) {
			LOGGER.info("Guest registration successfully......");
			return new ResponseEntity<Object>(guest1, HttpStatus.CREATED);
		}
		LOGGER.error("Registration Failed......Try again");
		errorResponse.setErrorMessage("Something went wrong......Couldn't register the guest");
		return new ResponseEntity<Object>(errorResponse, HttpStatus.NOT_FOUND);
	}

	/**
	 * Update guest.
	 *
	 * @param guestId
	 *            the guest id
	 * @param guest
	 *            the guest
	 * @return the response entity
	 */
	@PutMapping("/guest/update/{guestId}")
	public ResponseEntity<Object> updateGuest(@PathVariable long guestId, @RequestBody Guest guest) {

		ErrorResponse errorResponse = new ErrorResponse();
		LOGGER.info("Entering into /guest/update/{guestId}");

		long status = service.updateGuest(guest, guestId);
		Guest guest1 = service.getGuest(guestId);
		if (status > 0) {
			LOGGER.info("Guest updated successfully......");
			return new ResponseEntity<Object>(guest1, HttpStatus.CREATED);
		}
		LOGGER.error("Updation Failed......Try again");
		errorResponse.setErrorMessage("Something went wrong......Couldn't update guest information");
		return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	/**
	 * Gets the resort.
	 *
	 * @param guestId
	 *            the guest id
	 * @return the resort
	 */
	@GetMapping("/guest/get/{guestId}")
	public ResponseEntity<Object> getResort(@PathVariable long guestId) {
		ErrorResponse errorResponse = new ErrorResponse();
		LOGGER.info("Entering into /guest/get/{guestId}");

		Guest guest;

		guest = service.getGuest(guestId);
		if (guest != null) {
			LOGGER.info("Retrieving guest information successfull......");
			return new ResponseEntity<Object>(guest, HttpStatus.CREATED);
		}

		else {
			LOGGER.error("Retrieving guest information Failed......Try again");
			errorResponse.setErrorMessage("Something went wrong......Couldn't get the guest information");
			return new ResponseEntity<Object>(errorResponse, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * View itenarary.
	 *
	 * @param guestId
	 *            the guest id
	 * @return the list
	 */
	@GetMapping("/guest/view/{guestId}")
	public List<Object> viewItenarary(@PathVariable long guestId) {
		LOGGER.info("Entering into /guest/view/{guestId}");
		List<Object> list = new ArrayList<>();

		List<Resort> resort = resortService.getAllResort(guestId);
		List<Dining> dining = diningService.getAllDining(guestId);

		list.add(resort);
		list.add(dining);
		return list;

	}

}