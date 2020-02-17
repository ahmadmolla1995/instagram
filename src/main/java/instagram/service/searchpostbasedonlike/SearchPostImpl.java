package instagram.service.searchpostbasedonlike;

import instagram.config.annotation.Service;
import instagram.model.Post;
import instagram.repository.AccountRepository;
import instagram.repository.PostRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


@Service
public class SearchPostImpl implements SearchPostUseCase {
    @Override
    public void search() {
        List<Post> allPosts = PostRepository.getInstance().findAll();

        allPosts.sort(Comparator.comparing(Post::getLikes));
        Collections.reverse(allPosts);
        allPosts.forEach(p -> System.out.println(p.toString()));
    }
}
