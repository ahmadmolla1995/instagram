package instagram.service.unfollowaccount;

import instagram.config.annotation.UseCase;
import instagram.exception.UserAlreadySignedOutException;


@UseCase
public interface UnfollowAccountUseCase {
    void unfollowAccount(String account) throws UserAlreadySignedOutException;
}
