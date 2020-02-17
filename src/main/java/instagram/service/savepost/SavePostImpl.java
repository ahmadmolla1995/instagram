package instagram.service.savepost;

import instagram.config.annotation.Service;
import instagram.exception.PostNotFoundException;
import instagram.exception.UserAlreadySignedOutException;
import instagram.model.Account;
import instagram.repository.PostRepository;
import instagram.util.AuthenticationService;


@Service
public class SavePostImpl implements SavePostUseCase {
    @Override
    public void savePost(Long postID) throws UserAlreadySignedOutException, PostNotFoundException {
        Account currentUser = AuthenticationService.getCurrentUser();
        if (currentUser == null)
            throw new UserAlreadySignedOutException("The user is signed out! Please sign in at first");


        try {
            PostRepository.getInstance().find("id", postID.toString());
            SavedPostsContainer.insert(currentUser.getId(), postID);
        } catch (Exception e) {
            throw new PostNotFoundException("There isn't any post with this id to save!");
        }
    }
}
