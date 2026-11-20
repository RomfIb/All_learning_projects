import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public void save(User user) {
        users.add(user);
        System.out.println("User " + user + " is saved");
    }

    public Optional<User> findById(Integer id) {
        return users
                .stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public String findEmailIfActive(Integer id) {
        return findById(id)
                .stream()
                .filter(User::getActive)
                .map(User::getEmail)
                .findFirst()
                .orElseGet(() -> {
                    findById(id)
                            .ifPresentOrElse(
                                    user -> System.out.println("User " + user.getName() + " is not active"),
                                    () -> System.out.println("User with id " + id + " is not found")
                            );
                    return null;
                });
    }
}
