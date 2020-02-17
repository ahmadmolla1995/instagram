package instagram.exception;


public class UserAlreadySignedInException extends Exception {
    public UserAlreadySignedInException(String message) {
        super(message);
    }
}
