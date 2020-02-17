package instagram.service.deletepost;

import instagram.config.annotation.Service;
import instagram.exception.PostNotFoundException;
import instagram.exception.UserAlreadySignedOutException;
import instagram.model.Account;
import instagram.model.Post;
import instagram.repository.PostRepository;
import instagram.util.AuthenticationService;


@Service
public class DeletePostImpl implements DeletePostUseCase {
    @Override
    public void deletePost(Long postID) throws UserAlreadySignedOutException, PostNotFoundException {
        Account user = AuthenticationService.getCurrentUser();
        if (user == null)
            throw new UserAlreadySignedOutException("The user is signed out! Please sign in at first!");

        try {
            Post post = PostRepository.getInstance().find("id", postID.toString());
            if (post.getUser().getId().equals(user.getId()))
                PostRepository.getInstance().delete(post);
        } catch (Exception e) {
            throw new PostNotFoundException("The post id not found!");
        }
    }
}
