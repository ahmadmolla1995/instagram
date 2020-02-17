package instagram.service.searchaccount;

import instagram.config.annotation.Service;
import instagram.exception.PostNotFoundException;
import instagram.exception.UserAlreadySignedOutException;
import instagram.exception.UserNotFoundException;
import instagram.model.Account;
import instagram.repository.AccountRepository;
import instagram.util.AuthenticationService;
import javax.persistence.NoResultException;


@Service
public class SearchAccountImpl implements SearchAccountUseCase {
    @Override
    public Account searchAccount(String username) throws UserNotFoundException, UserAlreadySignedOutException, PostNotFoundException {
        if (AuthenticationService.getCurrentUser() == null)
            throw new UserAlreadySignedOutException("The user is signed out! Please sign in at first");

        if (username.equals(AuthenticationService.getCurrentUser().getUsername()))
            return AuthenticationService.getCurrentUser();


        try {
            AccountRepository repository = AccountRepository.getInstance();
            return repository.find("username", "\'" + username + "\'");
        } catch (NoResultException e) {
            throw new UserNotFoundException("This username doesn't exist in database");
        }
    }
}

