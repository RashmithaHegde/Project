package com.app.SpringBootProject.dao;


import com.app.SpringBootProject.bean.Guest;


/**
 * The Interface IGuestDao.
 */
public interface IGuestDao {

	/**
	 * Register guest.
	 *
	 * @param guest
	 *            the guest
	 * @return the guest
	 */
	public Guest registerGuest(Guest guest);

	/**
	 * Update guest.
	 *
	 * @param guest
	 *            the guest
	 * @param guestId
	 *            the guest id
	 * @return the long
	 */
	public long updateGuest(Guest guest,long guestId);

	/**
	 * Gets the guest.
	 *
	 * @param guestId
	 *            the guest id
	 * @return the guest
	 */
	public Guest getGuest(long guestId);

	/**
	 * Validate.
	 *
	 * @param email
	 *            the email
	 * @param password
	 *            the password
	 * @return the guest
	 */
	public Guest validate(String email, String password);
	
	
}
