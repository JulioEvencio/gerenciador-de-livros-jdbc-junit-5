package gerenciador.exception;

public class UpdateBookFailedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UpdateBookFailedException() {
		super();
	}

	public UpdateBookFailedException(String message) {
		super(message);
	}

}
