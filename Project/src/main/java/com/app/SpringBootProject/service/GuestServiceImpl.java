package com.app.SpringBootProject.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.SpringBootProject.bean.Guest;
import com.app.SpringBootProject.dao.IGuestDao;

/**
 * The Class GuestServiceImpl.
 */
@Service
public class GuestServiceImpl implements IGuestService{
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(GuestServiceImpl.class);

	/** The dao. */
	@Autowired
	IGuestDao dao;

	/**
	 * Register guest.
	 *
	 * @param guest
	 *            the guest
	 * @return the guest
	 */
	@Override
	public Guest registerGuest(Guest guest) {
		LOGGER.info("Entering into registerGuest in service layer");
		return dao.registerGuest(guest);
		
	}

	/**
	 * Update guest.
	 *
	 * @param guest
	 *            the guest
	 * @param guestId
	 *            the guest id
	 * @return the long
	 */
	@Override
	public long updateGuest(Guest guest, long guestId) {
		LOGGER.info("Entering into updateGuest in service layer");
	return dao.updateGuest(guest, guestId);
		
	}

	/**
	 * Gets the guest.
	 *
	 * @param guestId
	 *            the guest id
	 * @return the guest
	 */
	@Override
	public Guest getGuest(long guestId) {
		LOGGER.info("Entering into getGuest in service layer");
		
	return	dao.getGuest(guestId);
	}

	/**
	 * Validate.
	 *
	 * @param email
	 *            the email
	 * @param password
	 *            the password
	 * @return the guest
	 */
	@Override
	public Guest validate(String email, String password) {
		LOGGER.info("Entering into validate in service layer");
		
		return dao.validate(email, password);
	}

	
	
}
