package instagram.service.writecomment;

import instagram.config.annotation.UseCase;
import instagram.exception.PostNotFoundException;
import instagram.exception.UserAlreadySignedOutException;
import instagram.exception.UserNotFoundException;


@UseCase
public interface WriteCommentUseCase {
    void writeComment() throws UserAlreadySignedOutException, UserNotFoundException, PostNotFoundException;
}
