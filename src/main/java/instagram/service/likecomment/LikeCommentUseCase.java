package instagram.service.likecomment;

import instagram.config.annotation.UseCase;
import instagram.exception.PostNotFoundException;
import instagram.exception.UserAlreadySignedOutException;
import instagram.exception.UserNotFoundException;


@UseCase
public interface LikeCommentUseCase {
    void likeComment() throws UserAlreadySignedOutException, UserNotFoundException, PostNotFoundException;
}
