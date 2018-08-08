package com.app.SpringBootProject.dao;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.SpringBootProject.bean.Resort;
import com.app.SpringBootProject.bean.ResortRowMapper;

/**
 * The Class ResortDaoImpl.
 */
@Transactional
@Repository
public class ResortDaoImpl implements IResortDao {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LogManager.getLogger(ResortDaoImpl.class);

	/** The jdbc template. */
	@Autowired
	JdbcTemplate jdbcTemplate;

	/** The date. */
	Date date = new Date();

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
	public Resort registerResort(Resort resort, long guestId) {
		LOGGER.info("Entering into registerResort");

		String status = "booked";

		String query = "INSERT INTO resort(guest_id,room_type,arrival_date,departure_date,no_of_people,created_date,updated_date) VALUES (?,?,?,?,?,?,?)";

		long success;
		try {
			success = jdbcTemplate.update(query, guestId, resort.getRoomType(), resort.getArrivalDate(),
					resort.getDepartureDate(), resort.getNoOfPeople(), date, date);
			LOGGER.debug("query executed" + success);

		} catch (DataAccessException e) {
			LOGGER.error("DataAccessException occured in register resort. . .!!!" + e.getStackTrace());
			return null;
		}
		if (success == 1) {
			String query1 = "UPDATE resort SET status=? ";

			success = jdbcTemplate.update(query1, status);
			LOGGER.debug("query executed" + success);

		}

		Resort resort1 = jdbcTemplate.queryForObject(
				"select * from resort where r_reservation_number in(select max(r_reservation_number) from resort where guest_id="
						+ guestId + ");",
				new ResortRowMapper());

		LOGGER.debug("query executed" + resort1);
		return resort1;
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
	public long updateResort(Resort resort, long rReservationNumber) {

		LOGGER.info("Entering into updateResort");
		long success;

		String query = "UPDATE resort SET room_type=?, arrival_date=?, departure_date=?,no_of_people=?,updated_date=? WHERE r_reservation_number=?";
		try {
			success = jdbcTemplate.update(query, resort.getRoomType(), resort.getArrivalDate(),
					resort.getDepartureDate(), resort.getNoOfPeople(), date, rReservationNumber);

			LOGGER.debug("query executed" + success);
		} catch (DataAccessException e) {
			LOGGER.error("DataAccessException occured in update resort. . .!!!" + e.getStackTrace());
			return 0;
		}
		return success;
	}

	/**
	 * Gets the resort.
	 *
	 * @param rReservationNumber
	 *            the r reservation number
	 * @return the resort
	 */
	@Override
	public Resort getResort(long rReservationNumber) {
		LOGGER.info("Entering into getResort");
		Resort resort;
		try {
			resort = jdbcTemplate.queryForObject("SELECT * FROM resort WHERE rReservationNumber = ?",
					new Object[] { rReservationNumber }, new ResortRowMapper());
			LOGGER.debug("query executed" + resort);
		} catch (DataAccessException e) {
			LOGGER.error("DataAccessException occured in get resort. . .!!!" + e.getStackTrace());
			return null;
		}
		return resort;
	}

	/**
	 * Gets the all resort.
	 *
	 * @param guestId
	 *            the guest id
	 * @return the all resort
	 */
	@Override
	public List<Resort> getAllResort(long guestId) {
		LOGGER.info("Entering into getAllResort");
		String query = "SELECT * FROM RESORT WHERE guest_id=" + guestId + "";
		List<Resort> resort;
		try {
			resort = jdbcTemplate.query(query, new ResortRowMapper());
			LOGGER.debug("query executed" + resort);
		} catch (DataAccessException e) {
			LOGGER.error("DataAccessException occured in get All resort. . .!!!" + e.getStackTrace());
			return null;
		}
		return resort;
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
		LOGGER.info("Entering into cancelResort");

		String status = "cancelled";
		long success = 0;

		String query1 = "UPDATE resort SET status=? where rReservationNumber=" + rReservationNumber + "";

		try {
			success = jdbcTemplate.update(query1, status);
			LOGGER.debug("query executed" + success);
		} catch (DataAccessException e) {
			LOGGER.error("DataAccessException occured in cancel resort. . .!!!" + e.getStackTrace());
			return 0;
		}

		if (success == 1) {
			return rReservationNumber;
		}
		return 0;

	}

}
