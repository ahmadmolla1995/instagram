package instagram.service.editpost;

import instagram.config.annotation.Service;
import instagram.exception.PostNotFoundException;
import instagram.exception.UserAlreadySignedOutException;
import instagram.model.Account;
import instagram.model.Post;
import instagram.repository.PostRepository;
import instagram.util.AuthenticationService;

import javax.persistence.NoResultException;
import java.util.Scanner;


@Service
public class EditPostImpl implements EditPostUseCase {
    @Override
    public void editPost() throws PostNotFoundException, UserAlreadySignedOutException {
        Account user = AuthenticationService.getCurrentUser();
        if (user == null)
            throw new UserAlreadySignedOutException("The user is signed out! Please sign in at first.");

        System.out.print("post id:");
        Scanner scanner = new Scanner(System.in);
        long postID = scanner.nextLong();

        try {
            PostRepository repository = PostRepository.getInstance();
            Post post = repository.find("id", Long.toString(postID));
            System.out.println("Content\n====================\n" + post.getContent());
            System.out.print("new content:");
            String newContent = scanner.next();

            if (!newContent.equals(post.getContent())) {
                post.setContent(newContent);
                repository.update(post);
            }
            
        } catch (NoResultException e) {
            throw new PostNotFoundException("The post id not found!");
        }
    }
}
