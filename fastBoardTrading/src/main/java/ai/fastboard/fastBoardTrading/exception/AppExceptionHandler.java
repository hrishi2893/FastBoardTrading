package ai.fastboard.fastBoardTrading.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(SystemException.class)
	public ResponseEntity<String> handleSystemException(SystemException e) {
		return ResponseEntity.ok(e.getMessage());
	}
}
