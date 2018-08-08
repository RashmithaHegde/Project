package com.app.SpringBootProject.bean;

import java.util.Date;

/**
 * The Class Resort.
 */
public class Resort {

	/** The r reservation number. */
	private long rReservationNumber;

	/** The guest id. */
	private long guestId;

	/** The room type. */
	private String roomType;

	/** The arrival date. */
	private Date arrivalDate;

	/** The departure date. */
	private Date departureDate;

	/** The no of people. */
	private int noOfPeople;

	/** The status. */
	private String status;

	/** The created date. */
	private Date createdDate;

	/** The updated date. */
	private Date updatedDate;

	/**
	 * Instantiates a new resort.
	 */
	public Resort() {

	}

	/**
	 * Instantiates a new resort.
	 *
	 * @param rReservationNumber
	 *            the r reservation number
	 * @param guestId
	 *            the guest id
	 * @param roomType
	 *            the room type
	 * @param arrivalDate
	 *            the arrival date
	 * @param departureDate
	 *            the departure date
	 * @param noOfPeople
	 *            the no of people
	 * @param status
	 *            the status
	 * @param createdDate
	 *            the created date
	 * @param updatedDate
	 *            the updated date
	 */
	public Resort(long rReservationNumber, long guestId, String roomType, Date arrivalDate, Date departureDate,
			int noOfPeople, String status, Date createdDate, Date updatedDate) {
		super();
		this.rReservationNumber = rReservationNumber;
		this.guestId = guestId;
		this.roomType = roomType;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.noOfPeople = noOfPeople;
		this.status = status;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	/**
	 * Gets the r reservation number.
	 *
	 * @return the r reservation number
	 */
	public long getrReservationNumber() {
		return rReservationNumber;
	}

	/**
	 * Sets the r reservation number.
	 *
	 * @param rReservationNumber
	 *            the new r reservation number
	 */
	public void setrReservationNumber(long rReservationNumber) {
		this.rReservationNumber = rReservationNumber;
	}

	/**
	 * Gets the guest id.
	 *
	 * @return the guest id
	 */
	public long getGuestId() {
		return guestId;
	}

	/**
	 * Sets the guest id.
	 *
	 * @param guestId
	 *            the new guest id
	 */
	public void setGuestId(long guestId) {
		this.guestId = guestId;
	}

	/**
	 * Gets the room type.
	 *
	 * @return the room type
	 */
	public String getRoomType() {
		return roomType;
	}

	/**
	 * Sets the room type.
	 *
	 * @param roomType
	 *            the new room type
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	/**
	 * Gets the arrival date.
	 *
	 * @return the arrival date
	 */
	public Date getArrivalDate() {
		return arrivalDate;
	}

	/**
	 * Sets the arrival date.
	 *
	 * @param date
	 *            the new arrival date
	 */
	public void setArrivalDate(Date date) {
		this.arrivalDate = date;
	}

	/**
	 * Gets the departure date.
	 *
	 * @return the departure date
	 */
	public Date getDepartureDate() {
		return departureDate;
	}

	/**
	 * Sets the departure date.
	 *
	 * @param departureDate
	 *            the new departure date
	 */
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	/**
	 * Gets the no of people.
	 *
	 * @return the no of people
	 */
	public int getNoOfPeople() {
		return noOfPeople;
	}

	/**
	 * Sets the no of people.
	 *
	 * @param noOfPeople
	 *            the new no of people
	 */
	public void setNoOfPeople(int noOfPeople) {
		this.noOfPeople = noOfPeople;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status
	 *            the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the created date.
	 *
	 * @return the created date
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the created date.
	 *
	 * @param createdDate
	 *            the new created date
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Gets the updated date.
	 *
	 * @return the updated date
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * Sets the updated date.
	 *
	 * @param updatedDate
	 *            the new updated date
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Resort [rReservationNumber=" + rReservationNumber + ", guestId=" + guestId + ", roomType=" + roomType
				+ ", arrivalDate=" + arrivalDate + ", departureDate=" + departureDate + ", noOfPeople=" + noOfPeople
				+ ", status=" + status + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}

}
