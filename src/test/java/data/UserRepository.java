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

    public User getValidGoogleUser() {
        return new UserBuilder()
                .setEmail(rb.getString("googleEmail"))
                .setPassword(rb.getString("googlePassword"))
                .build();
    }

    public User getValidYahooUser() {
        return new UserBuilder()
                .setEmail(rb.getString("yahooEmail"))
                .setPassword(rb.getString("yahooPassword"))
                .build();
    }

    public User getValidRamblerUser() {
        return new UserBuilder()
                .setEmail(rb.getString("ramblerEmail"))
                .setPassword(rb.getString("ramblerPassword"))
                .build();
    }
}
