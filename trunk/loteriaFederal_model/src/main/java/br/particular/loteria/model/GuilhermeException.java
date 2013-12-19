package br.particular.loteria.model;

@SuppressWarnings("serial")
public class GuilhermeException extends RuntimeException {

	public GuilhermeException() {
		super();
	}

	public GuilhermeException(final String message) {
		super(message);
	}

	public GuilhermeException(final Throwable cause) {
		super(cause);
	}

	public GuilhermeException(final String message, final Throwable cause) {
		super(message, cause);
	}

}
