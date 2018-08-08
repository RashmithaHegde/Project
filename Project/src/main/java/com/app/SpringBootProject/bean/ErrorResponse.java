package com.app.SpringBootProject.bean;

/**
 * The Class ErrorResponse.
 */
public class ErrorResponse {

	/** The error message. */
	private String errorMessage;

	/**
	 * Instantiates a new error response.
	 */
	public ErrorResponse() {
		super();
	}

	/**
	 * Instantiates a new error response.
	 *
	 * @param errorMessage
	 *            the error message
	 */
	public ErrorResponse(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	/**
	 * Gets the error message.
	 *
	 * @return the error message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Sets the error message.
	 *
	 * @param errorMessage
	 *            the new error message
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
