package instagram.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity @Table
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String birthDate;

    @Column(nullable = false)
    private String nationality;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @ManyToMany(cascade = {CascadeType.ALL})
    private Set<Account> followers;

    @ManyToMany(mappedBy = "followers")
    private Set<Account> followedAccount;

    @OneToMany(mappedBy = "commentWriter")
    private List<Comment> comments;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;


    public Account() {}

    public Account(Long id, String username, String password, String firstName, String lastName,
                   String birthDate, String nationality, String email, String phoneNumber) {

        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.nationality = nationality;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.posts = new ArrayList<>();
        this.followers = new HashSet<>();
        this.followedAccount = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public void setPhoneNumber(String newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }

    public void addNewPost(Post post) {
        this.posts.add(post);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void addNewFollower(Account account) { this.followers.add(account); }

    public void addNewFollowedAccount(Account account) {
        this.followedAccount.add(account);
    }

    public void removeFollower (Account account) { this.followers.remove(account); }

    public void removeFollowedAccount (Account account) {
        this.followedAccount.remove(account);
    }


    @Override
    public String toString() {
        return "username:" + username + ' ' +
                "first name:" + firstName + ' '+
                "last name:" + lastName + ' ' +
                "email:" + email + ' ' +
                "nationality:" + nationality + ' ' +
                "birth date:" + birthDate + ' ' +
                "phone number:" + phoneNumber;
    }
}


