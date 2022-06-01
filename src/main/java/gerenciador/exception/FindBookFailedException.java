package gerenciador.exception;

public class FindBookFailedException extends Exception {

	private static final long serialVersionUID = 1L;

	public FindBookFailedException() {
		super();
	}

	public FindBookFailedException(String message) {
		super(message);
	}

}
