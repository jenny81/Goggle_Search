package data;

/**
 * Created by Admin on 22-Feb-16.
 */
public class UserImpl implements User {
    private String email;
    private String password;

    public UserImpl(UserBuilder userBuilder) {
        email = userBuilder.email;
        password = userBuilder.password;

    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


}

