package gerenciador.exception;

public class ConnectionFailedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ConnectionFailedException() {
		super();
	}

	public ConnectionFailedException(String message) {
		super(message);
	}

}
