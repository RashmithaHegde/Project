package com.app.SpringBootProject.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.SpringBootProject.bean.Resort;
import com.app.SpringBootProject.dao.ResortDaoImpl;

@Service
public class ResortServiceImpl implements IResortService {
	private static final Logger LOGGER = LogManager.getLogger(ResortServiceImpl.class);
	@Autowired
	private ResortDaoImpl dao;
	
	@Override
	public Resort registerResort(Resort resort,long guestId) {

		LOGGER.info("Entering into registerResort in service layer");
		 return dao.registerResort(resort,guestId);
		
	}

	@Override
	public long updateResort(Resort resort,long rReservationNumber) {
		LOGGER.info("Entering into updateResort in service layer");
		return dao.updateResort(resort,rReservationNumber);
		
	}

	@Override
	public Resort getResort(long rReservationNumber) {
		LOGGER.info("Entering into getResort in service layer");
		return dao.getResort(rReservationNumber);
	}

	@Override
	public List<Resort> getAllResort(long guestId) {
		LOGGER.info("Entering into getAllResort in service layer");
		return dao.getAllResort(guestId);
	}

	@Override
	public long cancelResort(long rReservationNumber) {
		LOGGER.info("Entering into cancelResort in service layer");
		return dao.cancelResort(rReservationNumber);
	}

}
