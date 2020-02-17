package instagram.service.searchaccount;

import instagram.config.annotation.UseCase;
import instagram.exception.PostNotFoundException;
import instagram.exception.UserAlreadySignedOutException;
import instagram.exception.UserNotFoundException;
import instagram.model.Account;


@UseCase
public interface SearchAccountUseCase {
    Account searchAccount(String username) throws UserNotFoundException, UserAlreadySignedOutException, PostNotFoundException;
}
