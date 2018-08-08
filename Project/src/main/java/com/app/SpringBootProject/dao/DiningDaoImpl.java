package com.app.SpringBootProject.dao;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.app.SpringBootProject.bean.Dining;
import com.app.SpringBootProject.bean.DiningRowMapper;

/**
 * The Class DiningDaoImpl.
 */
@Repository
public class DiningDaoImpl implements IDiningDao {

	/** The jdbc template. */
	@Autowired
	JdbcTemplate jdbcTemplate;

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(DiningDaoImpl.class);

	/** The date. */
	Date date = new Date();


	/**
	 * Register dining.
	 *
	 * @param dining
	 *            the dining
	 * @param guestId
	 *            the guest id
	 * @return the dining
	 */
	@Override
	public Dining registerDining(Dining dining, long guestId) {
		LOGGER.info("Entering into register dining");
		String status = "booked";

		String query = "INSERT INTO dining(guest_id,dining_type,arrival_date,no_of_people,created_date,updated_date) VALUES (?,?,?,?,?,?)";
		long success;
		try {

			success = jdbcTemplate.update(query, guestId, dining.getDiningType(), dining.getArrivalDate(),
					dining.getNoOfPeople(), date, date);

			LOGGER.debug("query executed" + success);
		} catch (DataAccessException e) {

			LOGGER.error("DataAccessException occured in register dining. . .!!!" + e.getMessage());
			return null;
		}

		if (success == 1) {
			String query1 = "UPDATE dining SET status=? ";

			success = jdbcTemplate.update(query1, status);
			LOGGER.info("status updated successfully");
			LOGGER.debug("query executed" + success);

		}

		Dining dining1 = jdbcTemplate.queryForObject(
				"select * from dining where d_reservation_number in(select max(d_reservation_number) from dining where guest_id="
						+ guestId + ");",
				new DiningRowMapper());
		LOGGER.debug("query executed" + dining1);
		return dining1;

	}

	/**
	 * Update dining.
	 *
	 * @param dining
	 *            the dining
	 * @param dReservationNumber
	 *            the d reservation number
	 * @return the long
	 */
	@Override
	public long updateDining(Dining dining, long dReservationNumber) {

		LOGGER.info("Entering into updateDining");
		String query = "UPDATE dining SET dining_type=?, arrival_date=?,no_of_people=?,updated_date=? "
				+ "WHERE d_reservation_number=?";

		long success;

		try {
			success = jdbcTemplate.update(query, dining.getDiningType(), dining.getArrivalDate(),
					dining.getNoOfPeople(), date, dReservationNumber);
			LOGGER.debug("query executed" + success);

		} catch (DataAccessException e) {
			LOGGER.error("DataAccessException occured in update dining. . .!!!" + e.getMessage());
			return 0;
		}

		return success;

	}

	/**
	 * Gets the dining.
	 *
	 * @param dReservationNumber
	 *            the d reservation number
	 * @return the dining
	 */
	@Override
	public Dining getDining(long dReservationNumber) {
		LOGGER.info("Entering into getDining");
		Dining dining;

		try {
			dining = jdbcTemplate.queryForObject("SELECT * FROM dining WHERE d_reservation_number = ?",
					new Object[] { dReservationNumber }, new DiningRowMapper());
		} catch (DataAccessException e) {
			LOGGER.error("DataAccessException occured in get dining. . .!!!" + e.getMessage());
			return null;
		}

		return dining;
	}

	/**
	 * Gets the all dining.
	 *
	 * @param guestId
	 *            the guest id
	 * @return the all dining
	 */
	@Override
	public List<Dining> getAllDining(long guestId) {
		LOGGER.info("Entering into getAllDining");
		String query = "SELECT * FROM DINING WHERE guest_id=" + guestId + "";
		List<Dining> dining;
		try {
			dining = jdbcTemplate.query(query, new DiningRowMapper());
			LOGGER.debug("query executed" + dining);
		} catch (DataAccessException e) {
			LOGGER.error("DataAccessException occured in get All Dining. . .!!!" + e.getMessage());
			return null;

		}
		return dining;

	}

	/**
	 * Cancel dining.
	 *
	 * @param dReservationNumber
	 *            the d reservation number
	 * @return the long
	 */
	@Override
	public long cancelDining(long dReservationNumber) {
		LOGGER.info("Entering into cancelDining");
		String status = "cancelled";
		long success;

		String query1 = "UPDATE dining SET status=? where d_reservation_number=" + dReservationNumber + "";

		try {

			success = jdbcTemplate.update(query1, status);
			LOGGER.debug("query executed" + success);

		} catch (Exception e) {
			LOGGER.error("DataAccessException occured in cancel dining. . .!!!" + e.getMessage());
			return 0;
		}
		if (success == 1) {
			return dReservationNumber;
		}
		return 0;

	}

}
