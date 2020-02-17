package instagram.service.viewprofile;

import instagram.config.annotation.UseCase;
import instagram.exception.UserAlreadySignedOutException;


@UseCase
public interface ViewProfileUseCase {
    void display() throws UserAlreadySignedOutException;
}
