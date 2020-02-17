package instagram.service.viewpost;

import instagram.config.annotation.UseCase;
import instagram.exception.PostNotFoundException;
import instagram.exception.UserAlreadySignedOutException;
import instagram.exception.UserNotFoundException;


@UseCase
public interface ViewPostUseCase {
    void viewPosts() throws UserAlreadySignedOutException, PostNotFoundException;
    void viewPostsByAccountName(String accountName) throws UserNotFoundException, UserAlreadySignedOutException, PostNotFoundException;
}


