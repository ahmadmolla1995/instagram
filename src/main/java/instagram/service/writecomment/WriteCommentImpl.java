package instagram.service.writecomment;

import instagram.config.annotation.Service;
import instagram.exception.PostNotFoundException;
import instagram.exception.UserAlreadySignedOutException;
import instagram.exception.UserNotFoundException;
import instagram.model.Account;
import instagram.model.Comment;
import instagram.model.Post;
import instagram.repository.AccountRepository;
import instagram.repository.CommentRepository;
import instagram.repository.PostRepository;
import instagram.service.searchaccount.SearchAccountImpl;
import instagram.util.AuthenticationService;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.Scanner;


@Service
public class WriteCommentImpl implements WriteCommentUseCase {
    @Override
    public void writeComment() throws UserAlreadySignedOutException, UserNotFoundException, PostNotFoundException {
        if (AuthenticationService.getCurrentUser() == null)
            throw new UserAlreadySignedOutException("The user is signed out! Please sign in at first.");

        Scanner scanner = new Scanner(System.in);
        System.out.print("account name:");
        String accountName = scanner.next();

        Account account = (new SearchAccountImpl()).searchAccount(accountName);

        List<Post> accountPosts = account.getPosts();
        if (accountPosts.isEmpty())
            throw new PostNotFoundException("This page doesn't have any post.");

        accountPosts.forEach(p -> System.out.println(p.toString()));
        System.out.print("post ID to insert comment:");
        long postID = scanner.nextLong();

        try {
            Post post = PostRepository.getInstance().find("id", Long.toString(postID));

            System.out.print("Comment:");
            String content = scanner.next();
            Comment comment = new Comment(null, content);
            comment.setPost(post);
            comment.setCommentWriter(AuthenticationService.getCurrentUser());
            CommentRepository.getInstance().save(comment);
            post.addComment(comment);

        } catch (NoResultException e) {
            throw new PostNotFoundException("There isn't any post with this id.");
        }
    }
}
