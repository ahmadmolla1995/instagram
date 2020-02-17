package instagram.service.likepost;

import instagram.config.annotation.Service;
import instagram.exception.PostNotFoundException;
import instagram.exception.UserAlreadySignedOutException;
import instagram.exception.UserNotFoundException;
import instagram.model.Account;
import instagram.model.Post;
import instagram.repository.PostRepository;
import instagram.service.searchaccount.SearchAccountImpl;
import instagram.util.AuthenticationService;

import java.util.List;
import java.util.Scanner;


@Service
public class LikePostImpl implements LikePostUseCase {
    @Override
    public void likePost() throws UserAlreadySignedOutException, UserNotFoundException, PostNotFoundException {
        if (AuthenticationService.getCurrentUser() == null)
            throw new UserAlreadySignedOutException("The user is signed out! Please sign in at first");

        System.out.print("account name:");
        Scanner scanner = new Scanner(System.in);
        String accountName = scanner.next();

        if (accountName.equals(AuthenticationService.getCurrentUser().getUsername()))
            return;

        Account account = (new SearchAccountImpl()).searchAccount(accountName);
        List<Post> accountPosts = account.getPosts();

        if (accountPosts.isEmpty())
            throw new PostNotFoundException("There isn't any post in this account to like!");
        else {
            accountPosts.forEach(p -> System.out.println(p.toString()));
            System.out.print("post id that you want to like:");
            long postID = scanner.nextLong();

            PostRepository postRepository = PostRepository.getInstance();
            Post post = postRepository.find("id", Long.toString(postID));
            post.like();
            postRepository.save(post);
        }
    }
}
