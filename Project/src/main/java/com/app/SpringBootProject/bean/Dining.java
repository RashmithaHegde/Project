package com.app.SpringBootProject.bean;

import java.util.Date;

import javax.validation.constraints.Size;

/**
 * The Class Dining.
 */
public class Dining {
	
	/** The d reservation number. */
	private long dReservationNumber;

	/** The guest id. */
	private long guestId;

	/** The dining type. */
	@Size(max = 50)
	private String diningType ;

	/** The arrival date. */
	private Date arrivalDate;

	/** The no of people. */
	private int noOfPeople;

	/** The status. */
	private String status;

	/** The created date. */
	private Date createdDate;

	/** The updated date. */
	private Date updatedDate;
	
	/**
	 * Instantiates a new dining.
	 */
	public Dining() {
	
	}

	/**
	 * Instantiates a new dining.
	 *
	 * @param dReservationNumber
	 *            the d reservation number
	 * @param guestId
	 *            the guest id
	 * @param diningType
	 *            the dining type
	 * @param arrivalDate
	 *            the arrival date
	 * @param noOfPeople
	 *            the no of people
	 * @param status
	 *            the status
	 * @param createdDate
	 *            the created date
	 * @param updatedDate
	 *            the updated date
	 */
	public Dining(long dReservationNumber, long guestId, String diningType, Date arrivalDate, int noOfPeople,
			String status, Date createdDate, Date updatedDate) {
		super();
		this.dReservationNumber = dReservationNumber;
		this.guestId = guestId;
		this.diningType = diningType;
		this.arrivalDate = arrivalDate;
		this.noOfPeople = noOfPeople;
		this.status = status;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	/**
	 * Gets the d reservation number.
	 *
	 * @return the d reservation number
	 */
	public long getdReservationNumber() {
		return dReservationNumber;
	}

	/**
	 * Sets the d reservation number.
	 *
	 * @param dReservationNumber
	 *            the new d reservation number
	 */
	public void setdReservationNumber(long dReservationNumber) {
		this.dReservationNumber = dReservationNumber;
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
	 * Gets the dining type.
	 *
	 * @return the dining type
	 */
	public String getDiningType() {
		return diningType;
	}

	/**
	 * Sets the dining type.
	 *
	 * @param diningType
	 *            the new dining type
	 */
	public void setDiningType(String diningType) {
		this.diningType = diningType;
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
	 * @param arrivalDate
	 *            the new arrival date
	 */
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
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
		return "Dining [dReservationNumber=" + dReservationNumber + ", guestId=" + guestId + ", diningType="
				+ diningType + ", arrivalDate=" + arrivalDate + ", noOfPeople=" + noOfPeople + ", status=" + status
				+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
	}
	
	
}
