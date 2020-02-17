package instagram.model;

import javax.persistence.*;


@Entity @Table
public class Comment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    private Post post;

    @ManyToOne
    private Account commentWriter;

    private Integer likes;


    public Comment() {}

    public Comment(Long id, String content) {
        this.id = id;
        this.content = content;
        this.likes = 0;
        this.post = new Post();
        this.commentWriter = new Account();
    }

    public String getContent() {
        return content;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Integer getLikes() {
        return likes;
    }

    public void like() {
        likes ++;
    }

    public Post getPost() {
        return post;
    }

    public void setCommentWriter(Account commentWriter) { this.commentWriter = commentWriter; }

    public Account getCommentWriter() { return commentWriter; }

    @Override
    public String toString() {
        return "ID: " + id + "  " + "content: " + content + "  " + "writer: " + commentWriter.getUsername();
    }
}
