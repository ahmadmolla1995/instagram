package instagram.service.savepost;

import instagram.config.annotation.UseCase;
import instagram.exception.PostNotFoundException;
import instagram.exception.UserAlreadySignedOutException;


@UseCase
public interface SavePostUseCase {
    void savePost(Long postID) throws UserAlreadySignedOutException, PostNotFoundException;
}
