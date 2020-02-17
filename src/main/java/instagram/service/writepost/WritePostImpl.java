package instagram.service.writepost;

import instagram.config.annotation.Service;
import instagram.exception.UserAlreadySignedOutException;
import instagram.model.Account;
import instagram.model.Post;
import instagram.repository.AccountRepository;
import instagram.repository.PostRepository;
import instagram.util.AuthenticationService;

import java.util.Scanner;


@Service
public class WritePostImpl implements WritePostUseCase {
    @Override
    public void writePost() throws UserAlreadySignedOutException {
        Account user = AuthenticationService.getCurrentUser();
        if (user == null)
            throw new UserAlreadySignedOutException("The user is signed out! please sign in at first.");

        System.out.println("content\n========================================");
        Scanner scanner = new Scanner(System.in);
        String content = scanner.next();

        Post post = new Post(null, content);
        post.setUser(user);
        PostRepository.getInstance().save(post);

        user.addNewPost(post);
        AccountRepository.getInstance().update(user);
    }
}
