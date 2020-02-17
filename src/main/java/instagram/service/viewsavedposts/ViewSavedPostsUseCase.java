package instagram.service.viewsavedposts;

import instagram.config.annotation.UseCase;
import instagram.exception.UserAlreadySignedOutException;


@UseCase
public interface ViewSavedPostsUseCase {
    void viewPosts() throws UserAlreadySignedOutException;
}
