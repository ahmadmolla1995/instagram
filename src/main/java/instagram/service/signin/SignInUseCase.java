package instagram.service.signin;

import instagram.config.annotation.UseCase;
import instagram.exception.IllegalPasswordException;
import instagram.exception.UserAlreadySignedInException;
import instagram.exception.UserNotFoundException;


@UseCase
public interface SignInUseCase {
    void signIn(String username, String password) throws UserAlreadySignedInException, UserNotFoundException, IllegalPasswordException;
}
