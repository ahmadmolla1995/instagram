package instagram.service.signout;

import instagram.config.annotation.UseCase;
import instagram.exception.UserAlreadySignedOutException;


@UseCase
public interface SignOutUseCase {
    void signOut() throws UserAlreadySignedOutException;
}
