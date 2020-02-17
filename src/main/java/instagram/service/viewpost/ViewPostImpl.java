package instagram.service.viewpost;

import instagram.config.annotation.Service;
import instagram.exception.PostNotFoundException;
import instagram.exception.UserAlreadySignedOutException;
import instagram.exception.UserNotFoundException;
import instagram.model.Account;
import instagram.model.Post;
import instagram.service.searchaccount.SearchAccountImpl;
import instagram.util.AuthenticationService;

import java.util.List;


@Service
public class ViewPostImpl implements ViewPostUseCase {
    @Override
    public void viewPosts() throws UserAlreadySignedOutException, PostNotFoundException {
        Account user = AuthenticationService.getCurrentUser();
        if (user == null)
            throw new UserAlreadySignedOutException("The user is signed out! Please sign in at first");

        List<Post> userPosts = user.getPosts();
        if (userPosts.isEmpty())
            throw new PostNotFoundException("You have not written any post yet!");
        else
            userPosts.forEach(p -> System.out.println(p.toString()));
    }

    public void viewPostsByAccountName(String accountName) throws UserNotFoundException, UserAlreadySignedOutException, PostNotFoundException {
        Account account = (new SearchAccountImpl()).searchAccount(accountName);
        List<Post> userPosts = account.getPosts();

        if (userPosts.isEmpty())
            throw new PostNotFoundException("This user has not written any post yet!");
        else
            userPosts.forEach(p -> System.out.println(p.toString()));
    }
}
