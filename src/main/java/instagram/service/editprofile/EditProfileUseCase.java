package instagram.service.editprofile;

import instagram.config.annotation.UseCase;
import instagram.exception.UserAlreadySignedOutException;


@UseCase
public interface EditProfileUseCase {
    void edit() throws UserAlreadySignedOutException;
}
