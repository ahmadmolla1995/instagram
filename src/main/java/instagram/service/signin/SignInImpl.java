package instagram.service.signin;

import instagram.config.annotation.Service;
import instagram.exception.IllegalPasswordException;
import instagram.exception.UserAlreadySignedInException;
import instagram.exception.UserNotFoundException;
import instagram.model.Account;
import instagram.repository.AccountRepository;
import instagram.util.AuthenticationService;

import javax.persistence.NoResultException;


@Service
public class SignInImpl implements SignInUseCase {
    @Override
    public void signIn(String username, String password) throws UserAlreadySignedInException, UserNotFoundException, IllegalPasswordException {
        Account user = AuthenticationService.getCurrentUser();
        if (user != null)
            throw new UserAlreadySignedInException("The user is already signed in!");
        

        AccountRepository repository = AccountRepository.getInstance();
        try {
            user = repository.find("username", "\'" + username + "\'");
        } catch (NoResultException e) {
            throw new UserNotFoundException("The user not found in database");
        }
        
        if (!user.getPassword().equals(password))
            throw new IllegalPasswordException("wrong password!");
        else {
            AuthenticationService.setCurrentUser(user);
        }
    }
}
