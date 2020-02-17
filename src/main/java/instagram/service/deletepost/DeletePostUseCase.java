package instagram.service.deletepost;

import instagram.config.annotation.UseCase;
import instagram.exception.PostNotFoundException;
import instagram.exception.UserAlreadySignedOutException;


@UseCase
public interface DeletePostUseCase {
    void deletePost(Long postID) throws UserAlreadySignedOutException, PostNotFoundException;
}
