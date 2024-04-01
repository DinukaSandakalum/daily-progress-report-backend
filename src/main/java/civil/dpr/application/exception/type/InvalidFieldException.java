package civil.dpr.application.exception.type;

public class InvalidFieldException extends RuntimeException{
    public InvalidFieldException() {
    }

    public InvalidFieldException(String message, Throwable cause) {
        super(message, cause);
    }
    public InvalidFieldException(String message) {
        super(message);
    }
}