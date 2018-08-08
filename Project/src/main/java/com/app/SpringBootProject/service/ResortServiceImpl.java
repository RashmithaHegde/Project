package com.app.SpringBootProject.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.SpringBootProject.bean.Resort;
import com.app.SpringBootProject.dao.ResortDaoImpl;

/**
 * The Class ResortServiceImpl.
 */
@Service
public class ResortServiceImpl implements IResortService {
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(ResortServiceImpl.class);

	/** The dao. */
	@Autowired
	private ResortDaoImpl dao;

	/**
	 * Register resort.
	 *
	 * @param resort
	 *            the resort
	 * @param guestId
	 *            the guest id
	 * @return the resort
	 */
	@Override
	public Resort registerResort(Resort resort,long guestId) {

		LOGGER.info("Entering into registerResort in service layer");
		 return dao.registerResort(resort,guestId);
		
	}

	/**
	 * Update resort.
	 *
	 * @param resort
	 *            the resort
	 * @param rReservationNumber
	 *            the r reservation number
	 * @return the long
	 */
	@Override
	public long updateResort(Resort resort,long rReservationNumber) {
		LOGGER.info("Entering into updateResort in service layer");
		return dao.updateResort(resort,rReservationNumber);
		
	}

	/**
	 * Gets the all resort.
	 *
	 * @param guestId
	 *            the guest id
	 * @return the all resort
	 */
	@Override
	public Resort getResort(long rReservationNumber) {
		LOGGER.info("Entering into getResort in service layer");
		return dao.getResort(rReservationNumber);
	}

	/**
	 * Gets the resort.
	 *
	 * @param rReservationNumber
	 *            the r reservation number
	 * @return the resort
	 */
	@Override
	public List<Resort> getAllResort(long guestId) {
		LOGGER.info("Entering into getAllResort in service layer");
		return dao.getAllResort(guestId);
	}

	/**
	 * Cancel resort.
	 *
	 * @param rReservationNumber
	 *            the r reservation number
	 * @return the long
	 */
	@Override
	public long cancelResort(long rReservationNumber) {
		LOGGER.info("Entering into cancelResort in service layer");
		return dao.cancelResort(rReservationNumber);
	}

}
