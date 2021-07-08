package br.com.dasa.testeDasa.dto;

public class ErrorResponseDTO {	
	
	public ErrorResponseDTO(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "ErrorResponseDTO [errorMessage=" + errorMessage + "]";
	}
}
