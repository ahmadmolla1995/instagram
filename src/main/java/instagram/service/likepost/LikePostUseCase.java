package instagram.service.likepost;

import instagram.config.annotation.UseCase;
import instagram.exception.PostNotFoundException;
import instagram.exception.UserAlreadySignedOutException;
import instagram.exception.UserNotFoundException;


@UseCase
public interface LikePostUseCase {
    void likePost() throws UserAlreadySignedOutException, UserNotFoundException, PostNotFoundException;
}
