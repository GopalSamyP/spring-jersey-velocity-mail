package com.mail.model;

import java.io.Serializable;

/**
 * The Class MailModel.
 */
public class MailModel implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	
	/** The from. */
	private String from;
	
	/** The receiver. */
	private String receiver;
	
	/** The sub. */
	private String sub;
	
	/** The message. */
	private String message;

	/**
	 * Gets the from.
	 *
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * Sets the from.
	 *
	 * @param from the new from
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * Gets the receiver.
	 *
	 * @return the receiver
	 */
	public String getReceiver() {
		return receiver;
	}

	/**
	 * Sets the receiver.
	 *
	 * @param receiver the new receiver
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	/**
	 * Gets the sub.
	 *
	 * @return the sub
	 */
	public String getSub() {
		return sub;
	}

	/**
	 * Sets the sub.
	 *
	 * @param sub the new sub
	 */
	public void setSub(String sub) {
		this.sub = sub;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
