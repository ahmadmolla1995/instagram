package instagram.service.viewprofile;

import instagram.config.annotation.Service;
import instagram.exception.UserAlreadySignedOutException;
import instagram.model.Account;
import instagram.util.AuthenticationService;


@Service
public class ViewProfileImpl implements ViewProfileUseCase {
    @Override
    public void display() throws UserAlreadySignedOutException {
        if (AuthenticationService.getCurrentUser() == null)
            throw new UserAlreadySignedOutException("The user is signed out now! please sign in at first.");

        Account account = AuthenticationService.getCurrentUser();
        System.out.println(account.toString());
    }
}
