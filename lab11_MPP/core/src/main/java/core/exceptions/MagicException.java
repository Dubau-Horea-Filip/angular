package core.exceptions;

public class MagicException extends RuntimeException{
    public MagicException(String message) {
        super(message);
    }

    public MagicException(String message, Throwable cause) {
        super(message, cause);
    }

    public MagicException(Throwable cause) {
        super(cause);
    }
}
