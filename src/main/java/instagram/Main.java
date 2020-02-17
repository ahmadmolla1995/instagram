package instagram;

import instagram.exception.CommandNotFoundException;
import instagram.service.deleteaccount.DeleteAccountImpl;
import instagram.service.deletepost.DeletePostImpl;
import instagram.service.editpost.EditPostImpl;
import instagram.service.editprofile.EditProfileImpl;
import instagram.service.followaccount.FollowAccountImpl;
import instagram.service.likecomment.LikeCommentImpl;
import instagram.service.likepost.LikePostImpl;
import instagram.service.savepost.SavePostImpl;
import instagram.service.searchaccount.SearchAccountImpl;
import instagram.service.searchpostbasedonlike.SearchPostImpl;
import instagram.service.signin.SignInImpl;
import instagram.service.signout.SignOutImpl;
import instagram.service.signup.CreateAccountImpl;
import instagram.service.unfollowaccount.UnfollowAccountImpl;
import instagram.service.viewpost.ViewPostImpl;
import instagram.service.viewprofile.ViewProfileImpl;
import instagram.service.viewsavedposts.ViewSavedPostsImpl;
import instagram.service.writecomment.WriteCommentImpl;
import instagram.service.writepost.WritePostImpl;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        while (true) {
            System.out.print("Enter your command:");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.next();
            
            try {
                if (command.equalsIgnoreCase("create_account")) {
                    System.out.print("username:");
                    String username = scanner.next();
                    System.out.print("password:");
                    String password = scanner.next();
                    System.out.print("first name:");
                    String firstName = scanner.next();
                    System.out.print("last name:");
                    String lastName = scanner.next();
                    System.out.print("birth date:");
                    String birthDate = scanner.next();
                    System.out.print("nationality:");
                    String nationality = scanner.next();
                    System.out.print("email:");
                    String email = scanner.next();
                    System.out.print("phone number:");
                    String phoneNumber = scanner.next();

                    CreateAccountImpl implementer = new CreateAccountImpl();
                    implementer.signUp(username, password, firstName, lastName, birthDate, nationality, email, phoneNumber);
                }

                else if (command.equalsIgnoreCase("signin")) {
                    System.out.print("username:");
                    String username = scanner.next();
                    System.out.print("password:");
                    String password = scanner.next();

                    SignInImpl implementer = new SignInImpl();
                    implementer.signIn(username, password);
                }

                else if (command.equalsIgnoreCase("signout")) {
                    SignOutImpl implementer = new SignOutImpl();
                    implementer.signOut();
                }

                else if (command.equalsIgnoreCase("view_profile")) {
                    ViewProfileImpl implementer = new ViewProfileImpl();
                    implementer.display();
                }

                else if (command.equalsIgnoreCase("edit_profile")) {
                    EditProfileImpl implementer = new EditProfileImpl();
                    implementer.edit();
                }

                else if (command.equalsIgnoreCase("delete_account")) {
                    DeleteAccountImpl implementer = new DeleteAccountImpl();
                    implementer.deleteAccount();
                }

                else if (command.equalsIgnoreCase("search_account")) {
                    System.out.print("username:");
                    String username = scanner.next();
                    SearchAccountImpl implementer = new SearchAccountImpl();
                    implementer.searchAccount(username);
                }

                else if (command.equalsIgnoreCase("view_post")) {
                    ViewPostImpl implementer = new ViewPostImpl();
                    implementer.viewPosts();
                }

                else if (command.equalsIgnoreCase("view_post_by_account")) {
                    System.out.print("account name:");
                    String accountName = scanner.next();
                    ViewPostImpl implementer = new ViewPostImpl();
                    implementer.viewPostsByAccountName(accountName);
                }

                else if (command.equalsIgnoreCase("write_post")) {
                    WritePostImpl implementer = new WritePostImpl();
                    implementer.writePost();
                }

                else if (command.equalsIgnoreCase("edit_post")) {
                    EditPostImpl implementer = new EditPostImpl();
                    implementer.editPost();
                }

                else if (command.equalsIgnoreCase("delete_post")) {
                    System.out.print("post ID:");
                    Long postID = scanner.nextLong();
                    DeletePostImpl implementer = new DeletePostImpl();
                    implementer.deletePost(postID);
                }

                else if (command.equalsIgnoreCase("like_post")) {
                    LikePostImpl implementer = new LikePostImpl();
                    implementer.likePost();
                }

                else if (command.equalsIgnoreCase("search_most_popular_posts")) {
                    SearchPostImpl implementer = new SearchPostImpl();
                    implementer.search();
                }

                else if (command.equalsIgnoreCase("write_comment")) {
                    WriteCommentImpl implementer = new WriteCommentImpl();
                    implementer.writeComment();
                }

                else if (command.equalsIgnoreCase("like_comment")) {
                    LikeCommentImpl implementer = new LikeCommentImpl();
                    implementer.likeComment();
                }

                else if (command.equalsIgnoreCase("save_post")) {
                    System.out.print("post id:");
                    Long postID = scanner.nextLong();
                    SavePostImpl implementer = new SavePostImpl();
                    implementer.savePost(postID);
                }

                else if (command.equalsIgnoreCase("view_saved_posts")) {
                    ViewSavedPostsImpl implementer = new ViewSavedPostsImpl();
                    implementer.viewPosts();
                }

                else if (command.equalsIgnoreCase("follow_account")) {
                    System.out.print("account name:");
                    String accountName = scanner.next();
                    FollowAccountImpl implementer = new FollowAccountImpl();
                    implementer.followAccount(accountName);
                }

                else if (command.equalsIgnoreCase("unfollow_account")) {
                    System.out.print("account name:");
                    String accountName = scanner.next();
                    UnfollowAccountImpl implementer = new UnfollowAccountImpl();
                    implementer.unfollowAccount(accountName);
                }

                else
                    throw new CommandNotFoundException("Command not found! try again.");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
