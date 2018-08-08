package com.app.SpringBootProject.dao;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.SpringBootProject.bean.Guest;
import com.app.SpringBootProject.bean.GuestRowMapper;

/**
 * The Class GuestDaoImpl.
 */
@Repository
public class GuestDaoImpl implements IGuestDao {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(GuestDaoImpl.class);
	/** The jdbc template. */
	@Autowired
	JdbcTemplate jdbcTemplate;
	/** The date. */
	Date date = new Date();

	/**
	 * Register guest.
	 *
	 * @param guest
	 *            the guest
	 * @return the guest
	 */
	@Override
	public Guest registerGuest(Guest guest) {
		LOGGER.info("Entering into register guest");

		long success;

		String query = "INSERT INTO guest(email,first_name,last_name,address,phone,password,created_date,updated_date) VALUES (?,?,?,?,?,?,?,?)";

		try {
			success = jdbcTemplate.update(query, guest.getEmail(), guest.getFirstName(), guest.getLastName(),
					guest.getAddress(), guest.getPhone(), guest.getPassword(), date, date);
			LOGGER.debug("query executed" + success);

		} catch (DataAccessException e) {
			LOGGER.error("DataAccessException occured in register guest. . .!!!" + e.getStackTrace());
			return null;
		}
		Guest guest1 = jdbcTemplate.queryForObject(
				"select * from guest where guest_id in(select max(guest_id) from guest);", new GuestRowMapper());

		LOGGER.debug("query executed: " + guest1);
		return guest1;

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
		LOGGER.info("Entering into updateGuest");
		long success;
		String query = "UPDATE guest SET  first_name=?,last_name=?,address=?,phone=?,password=? WHERE guest_id=?";

		try {
			success = jdbcTemplate.update(query, guest.getFirstName(), guest.getLastName(), guest.getAddress(),
					guest.getPhone(), guest.getPassword(), guestId);
			LOGGER.debug("query executed" + success);
		} catch (DataAccessException e) {
			LOGGER.error("DataAccessException occured in update guest .!!!");
			return 0;
		}

		return success;

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
		LOGGER.info("Entering into getGuest");
		Guest guest;
		try {
			guest = jdbcTemplate.queryForObject("SELECT * FROM guest WHERE guest_id = ?", new Object[] { guestId },
					new GuestRowMapper());
			LOGGER.debug("query executed" + guest);

		} catch (DataAccessException e) {
			LOGGER.error("DataAccessException occured in get guest. . .!!!");
			return null;
		}
		return guest;
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

		LOGGER.info("Entering into validate guest");

		Guest guest = new Guest();
		try {
			guest = jdbcTemplate.queryForObject("SELECT * FROM guest WHERE email = ? AND password =?",
					new Object[] { email, password }, new GuestRowMapper());
			LOGGER.debug("query executed" + guest);
		} catch (DataAccessException e) {
			LOGGER.error("DataAccessException occured while validating. . .!!!");
			return null;
		}

		return guest;
	}

}
