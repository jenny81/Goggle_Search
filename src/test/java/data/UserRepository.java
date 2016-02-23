package data;

import java.util.ResourceBundle;

/**
 * Created by Admin on 19-Feb-16.
 */
public class UserRepository {
    ResourceBundle rb = ResourceBundle.getBundle("users");
    private static volatile UserRepository instance = new UserRepository();

    private UserRepository() {
    }

    public static UserRepository get() {
        return instance;
    }

    public IUser getValidUser() {
        return new User.UserBuilder()
                .setEmail(rb.getString("email"))
                .setPassword(rb.getString("password"))
                .build();
    }
}
//IUser user = new User.Builder()

//return new IUser.Build().setEmail().setPassword().build();
//        get()
//                .setEmail(rb.getString("email"))
//                .setPassword(rb.getString("password"))
//                .build();
