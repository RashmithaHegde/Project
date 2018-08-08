package com.app.SpringBootProject.service;

import java.util.List;

import com.app.SpringBootProject.bean.Dining;

/**
 * The Interface IDiningService.
 */
public interface IDiningService {
	
	/**
	 * Register dining.
	 *
	 * @param dining
	 *            the dining
	 * @param guestId
	 *            the guest id
	 * @return the dining
	 */
	public Dining registerDining(Dining dining,long guestId);
	
	/**
	 * Update dining.
	 *
	 * @param dining
	 *            the dining
	 * @param dReservationNumber
	 *            the d reservation number
	 * @return the long
	 */
	public long updateDining(Dining dining,long dReservationNumber);

	/**
	 * Gets the dining.
	 *
	 * @param dReservationNumber
	 *            the d reservation number
	 * @return the dining
	 */
	public Dining getDining(long dReservationNumber);

	/**
	 * Gets the all dining.
	 *
	 * @param guestId
	 *            the guest id
	 * @return the all dining
	 */
	public List<Dining> getAllDining(long guestId);

	/**
	 * Cancel dining.
	 *
	 * @param dReservationNumber
	 *            the d reservation number
	 * @return the long
	 */
	public long cancelDining(long dReservationNumber);
}
