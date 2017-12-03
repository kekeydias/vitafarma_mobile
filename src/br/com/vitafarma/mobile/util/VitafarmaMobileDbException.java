package br.com.vitafarma.mobile.util;

import java.io.Serializable;

public class VitafarmaMobileDbException extends Exception implements Serializable {
	private static final long serialVersionUID = 7252239658737885318L;
	private String completeMessage;
	private String message;

	public VitafarmaMobileDbException() {
		super();
		this.completeMessage = "";
		this.message = "";
	}

	public VitafarmaMobileDbException(String message) {
		super(message);
		this.completeMessage = message;
	}

	@Override
	public String toString() {
		return this.completeMessage;
	}

	public VitafarmaMobileDbException(Exception e, String message) {
		super(e.getCause());
		this.message = message;
		this.completeMessage = this.extractMessage(e);
	}

	public String getCompleteMessage() {
		return this.completeMessage;
	}

	private String extractMessage(Throwable caught) {
		String caughtMessage = "";
		if (caught != null) {
			caughtMessage = "Message: " + caught.getMessage();
			Throwable throwable = caught.getCause();
			while (throwable != null) {
				caughtMessage += "\nCause: " + throwable.getMessage();
				throwable = throwable.getCause();
			}
		}
		return this.message + "\n\n" + caughtMessage;
	}
}