package instagram.util;


import instagram.model.Account;

public class AuthenticationService {
    private static Account currentUser;

    public static Account getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(Account account) {
        currentUser = account;
    }

    public static void removeCurrentUser() {
        currentUser = null;
    }
}
