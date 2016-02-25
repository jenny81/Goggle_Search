package data;

import java.util.ResourceBundle;

/**
 * Created by Admin on 19-Feb-16.
 */
public class UserRepository {
    ResourceBundle rb = ResourceBundle.getBundle("users");
    private static UserRepository instance = new UserRepository();

    private UserRepository() {
    }

    public static UserRepository get() {
        return instance;
    }

    public User getValidUser() {
        return new UserBuilder()
                .setEmail(rb.getString("email"))
                .setPassword(rb.getString("password"))
                .build();
    }
}
