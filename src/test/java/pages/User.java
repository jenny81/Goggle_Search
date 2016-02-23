package pages;


interface IEmail {
    IPassword setEmail(String email);
}

interface IPassword {
    IBuild setPassword(String password);
}

interface IBuild {
    IUser build();
}

public class User implements IEmail, IPassword, IBuild, IUser {
    private String email;
    private String password;

    private User() {
    }

    // set - - - - - - - - - -
    public static IEmail get() {
        return new User();
    }

    public IPassword setEmail(String email) {
        this.email = email;
        return this;
    }

    public IBuild setPassword(String password) {
        this.password = password;
        return this;
    }

    public IUser build() {
        return this;
    }

    // get - - - - - - - - - -

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
