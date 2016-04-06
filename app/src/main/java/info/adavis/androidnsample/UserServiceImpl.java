package info.adavis.androidnsample;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Annyce Davis
 */
public class UserServiceImpl implements UserService {

    List<User> users = new ArrayList<>();

    @Override
    public void saveUser(User user) {
        users.add(user);
    }
}
