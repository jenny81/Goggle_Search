package data;

/**
 * Created by Admin on 22-Feb-16.
 */
public class User implements IUser {
    private String email;
    private String password;

    private User(UserBuilder userBuilder) {
        this.email = userBuilder.email;
        this.password = userBuilder.password;

    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static class UserBuilder {
        private String email;
        private String password;

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
}

