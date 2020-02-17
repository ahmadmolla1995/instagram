package instagram.repository;

import instagram.model.Post;


public class PostRepository extends CrudRepository<Post, Long> {
    private static PostRepository postRepository;

    private PostRepository() {}

    @Override
    protected Class<Post> getEntityClass() {
        return Post.class;
    }

    public static PostRepository getInstance() {
        if (postRepository == null)
            postRepository = new PostRepository();
        return postRepository;
    }
}
