package data;

/**
 * Created by Admin on 23-Feb-16.
 */
public class UserBuilder {
    public String email;
    public String password;

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public User build() {
        return new User(this);
    }
}
