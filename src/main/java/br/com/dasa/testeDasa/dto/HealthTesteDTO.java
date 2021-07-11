package br.com.dasa.testeDasa.dto;

import java.util.Date;

public class HealthTesteDTO {

	private String title;
	
	private String message;
	
	private Date timestamp;

	public HealthTesteDTO(String title, String message, Date timestamp) {
		this.title = title;
		this.message = message;
		this.timestamp = timestamp;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "HealthTesteDTO [title=" + title + ", message=" + message + ", timestamp=" + timestamp + "]";
	}	
}
