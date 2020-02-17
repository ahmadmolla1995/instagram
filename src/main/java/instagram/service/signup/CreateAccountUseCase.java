package instagram.service.signup;

import instagram.config.annotation.UseCase;
import instagram.exception.UserAlreadyExistsException;
import instagram.exception.UserAlreadySignedInException;


@UseCase
public interface CreateAccountUseCase {
    void signUp(String username, String password, String firstName, String lastName,
                String birthDate, String nationality, String email, String phoneNumber) throws UserAlreadyExistsException, UserAlreadySignedInException;
}
