package instagram.repository;


import instagram.model.Comment;

public class CommentRepository extends CrudRepository<Comment, Long> {
    private static CommentRepository commentRepository;

    private CommentRepository() {}

    @Override
    protected Class<Comment> getEntityClass() {
        return Comment.class;
    }

    public static CommentRepository getInstance() {
        if (commentRepository == null)
            commentRepository = new CommentRepository();
        return commentRepository;
    }
}
