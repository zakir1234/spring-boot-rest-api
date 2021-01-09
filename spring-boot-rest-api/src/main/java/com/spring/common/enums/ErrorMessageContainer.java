package com.spring.common.enums;

/**
 * 
 * @author Zakir
 *
 */
public enum ErrorMessageContainer {
	
	MESSAGE_TYPE_BAD_REQUEST("Bad Request", "Request is not proper because %s is missing"),
	MESSAGE_TYPE_DUPlICATE_ENTRY("Duplicate Entry", "Already exist %s"),
	MESSAGE_TYPE_NULL_POINTER_EXCEPTION("Internal Server Error", "Server interupted internally because %s is empty"),
	MESSAGE_TYPE_RESOURCE_NOT_FOUND("Resource Not Found", "No Data found with %s"),
	MESSAGE_TYPE_UNAUTHORIZED("Unauthorized", "Unauthorized request with username %s"),
	MESSAGE_TYPE_SOMETHIN_WRONG("Something went wrong", "Something went wrong %s"), 
	MESSAGE_TYPE_EMPTY_LIST("Resource Not Found", "Desired List is empty"),;
	
	private final String messageTitle;
	private final String messageDetails;
	
	private ErrorMessageContainer(String messageTitle, String messageDetails) {
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
