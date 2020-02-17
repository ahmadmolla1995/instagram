package instagram.service.deleteaccount;

import instagram.config.annotation.Service;
import instagram.exception.UserAlreadySignedOutException;
import instagram.model.Account;
import instagram.repository.AccountRepository;
import instagram.util.AuthenticationService;


@Service
public class DeleteAccountImpl implements DeleteAccountUseCase {
    @Override
    public void deleteAccount() throws UserAlreadySignedOutException {
        Account currentUser = AuthenticationService.getCurrentUser();
        if (currentUser == null)
            throw new UserAlreadySignedOutException("The user is signed out! Please sign in at first.");

        AccountRepository repository = AccountRepository.getInstance();
        repository.delete(currentUser);
    }
}
