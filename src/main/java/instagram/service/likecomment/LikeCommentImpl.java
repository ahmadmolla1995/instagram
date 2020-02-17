package instagram.service.likecomment;

import instagram.config.annotation.Service;
import instagram.exception.PostNotFoundException;
import instagram.exception.UserAlreadySignedOutException;
import instagram.exception.UserNotFoundException;
import instagram.model.Account;
import instagram.model.Comment;
import instagram.model.Post;
import instagram.repository.CommentRepository;
import instagram.repository.PostRepository;
import instagram.service.searchaccount.SearchAccountImpl;
import instagram.util.AuthenticationService;

import java.util.List;
import java.util.Scanner;


@Service
public class LikeCommentImpl implements LikeCommentUseCase {
    @Override
    public void likeComment() throws UserAlreadySignedOutException, UserNotFoundException, PostNotFoundException {
        if (AuthenticationService.getCurrentUser() == null)
            throw new UserAlreadySignedOutException("The user is signed out. Please sign in at first.");

        Scanner scanner = new Scanner(System.in);
        System.out.print("account name:");
        String accountName = scanner.next();
        Account account = (new SearchAccountImpl()).searchAccount(accountName);

        List<Post> accountPosts = account.getPosts();
        accountPosts.forEach(p -> System.out.println(p.toString()));
        System.out.print("post id:");
        long postID = scanner.nextLong();
        Post post = PostRepository.getInstance().find("id", Long.toString(postID));

        List<Comment> postComments = post.getComments();
        System.out.println("Comments\n=============================\n");
        postComments.forEach(c -> System.out.println(c.toString()));

        System.out.print("comment id that you want to like:");
        long commentID = scanner.nextLong();
        Comment comment = CommentRepository.getInstance().find("id", Long.toString(commentID));
        comment.like();
        CommentRepository.getInstance().update(comment);
    }
}
