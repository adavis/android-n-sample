package info.adavis.androidnsample;

/**
 * @author Annyce Davis
 */
public interface UserService {

    void saveUser(User user);

    static String getUserFullName(User user) {
        return user.getFirstName() + " " + user.getLastName();
    }
}
