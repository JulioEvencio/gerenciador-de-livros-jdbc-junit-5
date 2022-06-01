package gerenciador.exception;

public class DeleteBookFailedException extends Exception {

	private static final long serialVersionUID = 1L;

	public DeleteBookFailedException() {
		super();
	}

	public DeleteBookFailedException(String message) {
		super(message);
	}

}
