package instagram.service.followaccount;

import instagram.config.annotation.UseCase;
import instagram.exception.UserAlreadySignedOutException;
import instagram.exception.UserNotFoundException;


@UseCase
public interface FollowAccountUseCase {
    void followAccount(String accountName) throws UserAlreadySignedOutException, UserNotFoundException;
}
