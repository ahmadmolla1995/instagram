package instagram.service.viewsavedposts;

import instagram.config.annotation.Service;
import instagram.exception.UserAlreadySignedOutException;
import instagram.model.Account;
import instagram.model.Post;
import instagram.repository.PostRepository;
import instagram.service.savepost.SavedPostsContainer;
import instagram.util.AuthenticationService;

import java.util.ArrayList;
import java.util.List;


@Service
public class ViewSavedPostsImpl implements ViewSavedPostsUseCase {
    @Override
    public void viewPosts() throws UserAlreadySignedOutException {
        Account currentAccount = AuthenticationService.getCurrentUser();
        if (currentAccount == null)
            throw new UserAlreadySignedOutException("The user is signed out! Please sign in at first.");

        PostRepository repository = PostRepository.getInstance();
        List<Long> savedPostsID = SavedPostsContainer.getPostsByUserID(currentAccount.getId());

        List<Post> posts = new ArrayList<>();
        for(Long id: savedPostsID)
            posts.add(repository.find("id", id.toString()));

        posts.forEach(p -> System.out.println(p.toString()));

    }
}
