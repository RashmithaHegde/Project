package com.app.SpringBootProject.GuestController;

import java.util.ArrayList;
import java.util.List;

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
import com.app.SpringBootProject.bean.Guest;
import com.app.SpringBootProject.bean.Resort;
import com.app.SpringBootProject.service.IDiningService;
import com.app.SpringBootProject.service.IGuestService;
import com.app.SpringBootProject.service.IResortService;

@RestController
@CrossOrigin(origins = "*")
public class GuestController {
	// private static final Logger LOGGER =
	// Logger.getLogger("GuestController.class");
	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(GuestController.class);
	private static final Logger LOGGER = LogManager.getLogger(GuestController.class);
	@Autowired
	IGuestService service;

	@Autowired
	IDiningService diningService;

	@Autowired
	IResortService resortService;

	@PostMapping("/guest/login")
	public ResponseEntity<Guest> login(@RequestBody Guest guest) {
		LOGGER.info("Entering into /guest/login");

		Guest guest1 = service.validate(guest.getEmail(), guest.getPassword());

		if (guest1 == null) {

			LOGGER.error("Login Failed......Try again");
			return new ResponseEntity<Guest>(HttpStatus.NOT_FOUND);

		}

		LOGGER.info("Successfully logged in");
		return new ResponseEntity<Guest>(guest1, HttpStatus.ACCEPTED);

	}

	@PostMapping("/guest/register")
	public ResponseEntity<Guest> register(@RequestBody Guest guest) {

		LOGGER.info("Entering into /guest/register");

		Guest guest1 = service.registerGuest(guest);
		if (guest1 != null) {
			LOGGER.info("Guest registration successfully......");
			return new ResponseEntity<Guest>(guest1, HttpStatus.CREATED);
		}
		LOGGER.error("Registration Failed......Try again");
		return new ResponseEntity<Guest>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/guest/update/{guestId}")
	public ResponseEntity<Guest> updateGuest(@PathVariable long guestId, @RequestBody Guest guest) {
		LOGGER.info("Entering into /guest/update/{guestId}");

		long status = service.updateGuest(guest, guestId);
		Guest guest1 = service.getGuest(guestId);
		if (status > 0) {
			LOGGER.info("Guest updated successfully......");
			return new ResponseEntity<Guest>(guest1, HttpStatus.CREATED);
		}
		LOGGER.error("Updation Failed......Try again");
		return new ResponseEntity<Guest>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/guest/get/{guestId}")
	public ResponseEntity<Guest> getResort(@PathVariable long guestId) {
		LOGGER.info("Entering into /guest/get/{guestId}");

		Guest guest;

		guest = service.getGuest(guestId);
		if (guest != null) {
			LOGGER.info("Retrieving guest information successfull......");
			return new ResponseEntity<Guest>(guest, HttpStatus.CREATED);
		}

		else {
			LOGGER.error("Retrieving guest information Failed......Try again");
			return new ResponseEntity<Guest>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/guest/view/{guestId}")
	public List viewItenarary(@PathVariable long guestId) {
		LOGGER.info("Entering into /guest/view/{guestId}");
		List list = new ArrayList<>();

		List<Resort> resort = resortService.getAllResort(guestId);
		List<Dining> dining = diningService.getAllDining(guestId);

		list.add(resort);
		list.add(dining);
		return list;

	}

}
