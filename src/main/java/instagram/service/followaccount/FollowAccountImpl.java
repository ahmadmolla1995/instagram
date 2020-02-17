package instagram.service.followaccount;

import instagram.config.annotation.Service;
import instagram.exception.UserAlreadySignedOutException;
import instagram.exception.UserNotFoundException;
import instagram.model.Account;
import instagram.repository.AccountRepository;
import instagram.util.AuthenticationService;


@Service
public class FollowAccountImpl implements FollowAccountUseCase {
    @Override
    public void followAccount(String accountName) throws UserAlreadySignedOutException, UserNotFoundException {
        Account currentAccount = AuthenticationService.getCurrentUser();
        if (currentAccount == null)
            throw new UserAlreadySignedOutException("The user is signed out! Please sign in at first");
        if (currentAccount.getUsername().equals(accountName))
            return;


        try {
            AccountRepository repository = AccountRepository.getInstance();
            Account followedAccount = repository.find("username", "\'" + accountName + "\'");

            followedAccount.addNewFollower(currentAccount);
            repository.update(followedAccount);
            currentAccount.addNewFollowedAccount(followedAccount);
            repository.update(currentAccount);

        } catch (Exception e) {
            throw new UserNotFoundException("The account not found!");
        }
    }
}
