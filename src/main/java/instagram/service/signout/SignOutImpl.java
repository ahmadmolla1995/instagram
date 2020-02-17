package instagram.service.signout;

import instagram.config.annotation.Service;
import instagram.exception.UserAlreadySignedOutException;
import instagram.util.AuthenticationService;


@Service
public class SignOutImpl implements SignOutUseCase {
    @Override
    public void signOut() throws UserAlreadySignedOutException {
        if (AuthenticationService.getCurrentUser() == null)
            throw new UserAlreadySignedOutException("The user is already signed out!");

        AuthenticationService.removeCurrentUser();
    }
}
