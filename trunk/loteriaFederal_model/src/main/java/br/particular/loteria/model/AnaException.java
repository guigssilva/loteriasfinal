package br.particular.loteria.model;

@SuppressWarnings("serial")
public class AnaException extends RuntimeException {

	public AnaException() {
		super();
	}

	public AnaException(final String message) {
		super(message);
	}

	public AnaException(final Throwable cause) {
		super(cause);
	}

	public AnaException(final String message, final Throwable cause) {
		super(message, cause);
	}

}
