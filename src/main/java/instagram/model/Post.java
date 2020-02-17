package instagram.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity @Table
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Account user;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    private Integer likes;
    private String content;


    public Post() {}

    public Post(Long id, String content) {
        this.id = id;
        this.content = content;
        this.likes = 0;
        this.comments = new ArrayList<>();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikes() {
        return likes;
    }

    public void like() {
        this.likes ++;
    }

    public Account getUser() { return user; }

    public void setUser(Account user) { this.user = user; }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public List<Comment> getComments() { return comments; }


    @Override
    public String toString() {
        return "ID: " + id + "  " + "content: " + content + "  " + "likes: " + likes;
    }
}
