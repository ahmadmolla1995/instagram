package instagram.service.deleteaccount;

import instagram.config.annotation.UseCase;
import instagram.exception.UserAlreadySignedOutException;


@UseCase
public interface DeleteAccountUseCase {
    void deleteAccount() throws UserAlreadySignedOutException;
}
