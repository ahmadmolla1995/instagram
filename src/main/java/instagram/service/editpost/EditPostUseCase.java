package instagram.service.editpost;

import instagram.config.annotation.UseCase;
import instagram.exception.PostNotFoundException;
import instagram.exception.UserAlreadySignedOutException;


@UseCase
public interface EditPostUseCase {
    void editPost() throws PostNotFoundException, UserAlreadySignedOutException;
}
