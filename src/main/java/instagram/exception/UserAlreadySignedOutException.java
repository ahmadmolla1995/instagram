package instagram.exception;


public class UserAlreadySignedOutException extends Exception {
    public UserAlreadySignedOutException(String message) {
        super(message);
    }
}
