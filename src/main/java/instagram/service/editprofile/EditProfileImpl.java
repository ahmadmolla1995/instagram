package instagram.service.editprofile;

import instagram.config.annotation.Service;
import instagram.exception.UserAlreadySignedOutException;
import instagram.model.Account;
import instagram.util.AuthenticationService;

import java.util.Scanner;


@Service
public class EditProfileImpl implements EditProfileUseCase {
    @Override
    public void edit() throws UserAlreadySignedOutException {
        Account currentUser = AuthenticationService.getCurrentUser();
        if (currentUser == null)
            throw new UserAlreadySignedOutException("The user is signed out! please sign in at first");

        editUsername(currentUser);
        editPassword(currentUser);
        editEmail(currentUser);
        editPhoneNumber(currentUser);
    }

    private static void editUsername (Account currentUser) {
        System.out.print("new username:");
        Scanner scanner = new Scanner(System.in);
        String newUsername = scanner.next();

        if (currentUser.getUsername().equals(newUsername))
            return;
        currentUser.setUsername(newUsername);
    }

    private static void editPassword(Account currentUser) {
        System.out.print("new password:");
        Scanner scanner = new Scanner(System.in);
        String newPassword = scanner.next();

        if (currentUser.getPassword().equals(newPassword))
            return;
        currentUser.setPassword(newPassword);
    }

    private static void editEmail(Account currentUser) {
        System.out.print("new email:");
        Scanner scanner = new Scanner(System.in);
        String newEmail = scanner.next();

        if (currentUser.getEmail().equals(newEmail))
            return;
        currentUser.setEmail(newEmail);
    }

    private static void editPhoneNumber(Account currentUser) {
        System.out.print("new phone number:");
        Scanner scanner = new Scanner(System.in);
        String newPhoneNumber = scanner.next();

        if (currentUser.getPhoneNumber().equals(newPhoneNumber))
            return;
        currentUser.setPhoneNumber(newPhoneNumber);
    }
}
