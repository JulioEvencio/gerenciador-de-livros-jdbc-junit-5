package gerenciador.exception;

public class SaveBookFailedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SaveBookFailedException() {
		super();
	}

	public SaveBookFailedException(String message) {
		super(message);
	}

}
