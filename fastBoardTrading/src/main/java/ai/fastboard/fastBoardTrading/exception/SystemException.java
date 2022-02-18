package ai.fastboard.fastBoardTrading.exception;

public class SystemException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SystemException(String message, Throwable e) {
		super(message, e);
	}
}
