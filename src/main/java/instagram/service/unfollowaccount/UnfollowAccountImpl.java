package instagram.service.unfollowaccount;

import instagram.config.annotation.Service;
import instagram.exception.UserAlreadySignedOutException;
import instagram.model.Account;
import instagram.repository.AccountRepository;
import instagram.util.AuthenticationService;


@Service
public class UnfollowAccountImpl implements UnfollowAccountUseCase {
    @Override
    public void unfollowAccount(String accountName) throws UserAlreadySignedOutException {
        Account currentAccount = AuthenticationService.getCurrentUser();
        if (currentAccount == null)
            throw new UserAlreadySignedOutException("The user is signed out! Please sign in at first");
        if (currentAccount.getUsername().equals(accountName))
            return;


        try {
            AccountRepository repository = AccountRepository.getInstance();
            Account followedAccount = repository.find("username", "\'" + accountName + "\'");

            followedAccount.removeFollower(currentAccount);
            repository.update(followedAccount);
            currentAccount.removeFollowedAccount(followedAccount);
            repository.update(currentAccount);

        } catch (Exception e) {
        }
    }
}
