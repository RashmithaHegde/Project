package com.app.SpringBootProject.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.SpringBootProject.bean.Dining;
import com.app.SpringBootProject.dao.DiningDaoImpl;

@Service
public class DiningServiceImpl implements IDiningService {
	private static final Logger LOGGER = LogManager.getLogger(DiningServiceImpl.class);
	@Autowired
	DiningDaoImpl dao;

	@Override
	public Dining registerDining(Dining dining,long guestId) {
		LOGGER.info("Entering into registerDining in service layer");
		return dao.registerDining(dining, guestId);
	}

	@Override
	public long updateDining(Dining dining, long dReservationNumber) {
		LOGGER.info("Entering into updateDining in service layer");
		return dao.updateDining(dining, dReservationNumber);
	}

	@Override
	public Dining getDining(long dReservationNumber) {
		LOGGER.info("Entering into getDining in service layer");
		return dao.getDining(dReservationNumber);
	}

	@Override
	public List<Dining> getAllDining(long guestId) {
		LOGGER.info("Entering into getAllDining in service layer");
		return dao.getAllDining(guestId);
	}

	@Override
	public long cancelDining(long dReservationNumber) {
		LOGGER.info("Entering into cancelDining in service layer");
		
		return dao.cancelDining(dReservationNumber);
	}

	

	
}
