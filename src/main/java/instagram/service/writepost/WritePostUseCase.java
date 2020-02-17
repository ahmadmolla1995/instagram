package instagram.service.writepost;

import instagram.config.annotation.UseCase;
import instagram.exception.UserAlreadySignedOutException;


@UseCase
public interface WritePostUseCase {
    void writePost() throws UserAlreadySignedOutException;
}
