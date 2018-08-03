package com.app.SpringBootProject.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.SpringBootProject.bean.Guest;
import com.app.SpringBootProject.dao.IGuestDao;

@Service
public class GuestServiceImpl implements IGuestService{
	private static final Logger LOGGER = LogManager.getLogger(GuestServiceImpl.class);

	@Autowired
	IGuestDao dao;

	@Override
	public Guest registerGuest(Guest guest) {
		LOGGER.info("Entering into registerGuest in service layer");
		return dao.registerGuest(guest);
		
	}

	@Override
	public long updateGuest(Guest guest, long guestId) {
		LOGGER.info("Entering into updateGuest in service layer");
	return dao.updateGuest(guest, guestId);
		
	}

	@Override
	public Guest getGuest(long guestId) {
		LOGGER.info("Entering into getGuest in service layer");
		
	return	dao.getGuest(guestId);
	}

	@Override
	public Guest validate(String email, String password) {
		LOGGER.info("Entering into validate in service layer");
		
		return dao.validate(email, password);
	}

	
	
}
