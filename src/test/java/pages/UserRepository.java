package pages;

/**
 * Created by Admin on 19-Feb-16.
 */
public class UserRepository {

    private static volatile UserRepository instance = null;

    private UserRepository() {
    }

    public static UserRepository get() {
        if (instance == null) {
            synchronized (UserRepository.class) {
                if (instance == null) {
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }

    public IUser getValidUser() {

        return User.get()
                .setEmail("jenny.yud81@gmail.com")
                .setPassword("8bv4gf2tr")
                .build();
    }
}
