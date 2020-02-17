package instagram.service.signup;

import instagram.config.annotation.Service;
import instagram.exception.UserAlreadyExistsException;
import instagram.exception.UserAlreadySignedInException;
import instagram.model.Account;
import instagram.repository.AccountRepository;
import instagram.util.AuthenticationService;

import javax.persistence.NoResultException;


@Service
public class CreateAccountImpl implements CreateAccountUseCase {
    @Override
    public void signUp(String username, String password, String firstName, String lastName, String birthDate, String nationality, String email, String phoneNumber) throws UserAlreadyExistsException, UserAlreadySignedInException {

        if (AuthenticationService.getCurrentUser() != null)
            throw new UserAlreadySignedInException("The user is signed in! Please sign out at first");

        try {
            AccountRepository repository = AccountRepository.getInstance();
            Account account = new Account(null, username, password, firstName, lastName, birthDate, nationality, email, phoneNumber);
            repository.save(account);
        } catch (NoResultException e) {
            throw new UserAlreadyExistsException("User already exists in database.");
        }
    }
}

