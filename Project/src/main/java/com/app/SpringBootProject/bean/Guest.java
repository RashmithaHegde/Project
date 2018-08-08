package com.app.SpringBootProject.bean;

import java.sql.Date;

//TODO: Auto-generated Javadoc
/**
 * The Class Guest.
 */
public class Guest {
	
	/** The guest id. */
	private long guestId;

	/** The email. */
	private String email;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The address. */
	private String address;

	/** The phone. */
	private String phone;

	/** The password. */
	private String password;

	/** The created date. */
	private Date createdDate;

	/** The updated date. */
	private Date updatedDate;

	/**
	 * Instantiates a new guest.
	 */
	public Guest() {
		super();
	}

	/**
	 * Instantiates a new guest.
	 *
	 * @param email
	 *            the email
	 * @param firstName
	 *            the first name
	 * @param lastName
	 *            the last name
	 * @param address
	 *            the address
	 * @param phone
	 *            the phone
	 * @param password
	 *            the password
	 */
	public Guest(String email, String firstName, String lastName, String address, String phone, String password) {
		super();

		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.password = password;

	}

	/**
	 * Gets the guest id.
	 *
	 * @return the guest id
	 */
	public long getguestId() {
		return guestId;
	}

	/**
	 * Sets the guest id.
	 *
	 * @param guestId
	 *            the new guest id
	 */
	public void setguestId(long guestId) {
		this.guestId = guestId;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName
	 *            the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName
	 *            the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address
	 *            the new address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone
	 *            the new phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
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
	public Date getupdatedDate() {
		return updatedDate;
	}

	/**
	 * Sets the updated date.
	 *
	 * @param updatedDate
	 *            the new updated date
	 */
	public void setupdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "GuestProfile [guestId=" + guestId + ", email=" + email + ", firstName=" + firstName + ", lastName="
				+ lastName + ", address=" + address + ", phone=" + phone + ", password=" + password + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + "]";
	}

}
