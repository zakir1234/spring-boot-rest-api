package com.spring.common.enums;

/**
 * 
 * @author Zakir
 *
 */
public enum MessageContainer {
	
	MESSAGE_SAVE_SUCCESS("Success", "Successfully saved"),
	MESSAGE_UPDATE_SUCCESS("Success", "Successfully updated"),
	MESSAGE_DELETE_SUCCESS("Success", "Successfully deleted");
	
	private final String messageTitle;
	private final String messageDetails;
	
	private MessageContainer(String messageTitle, String messageDetails) {
		this.messageTitle = messageTitle;
		this.messageDetails = messageDetails;
	}

	public String getMessageDetails() {
		return messageDetails;
	}

	public String getMessageTitle() {
		return messageTitle;
	}
	
}
