import Enum.*;

import java.util.ArrayList;
import java.util.List;

public class User {
    public static List<User> users = new ArrayList<>();
    private Integer id;
    private String name;
    private String email;
    private Double balance;


    public User(Integer id, String name, String email, Double balance) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.balance = balance;
        users.add(this);
    }

    @Role(RoleType.OPERATOR)
    public static void changeEmailById (Integer id, String newEmail) {
        if (!Main.isValidEmail(newEmail)) {
            System.out.println("New email is invalid");
            return;
        }
        users
                .stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .ifPresentOrElse(user -> user.setEmail(newEmail),
                        () ->System.out.println("User with id " + id + " does not exist"));
//        boolean found = false;
//        for (User user: users) {
//            if (user.getId().equals(id)) {
//                user.setEmail(newEmail);
//                found = true;
//            }
//        }
//        if (!found)
//            System.out.println("User with id " + id + " does not exist");
    }

    @Role(RoleType.ADMIN)
    public static void deleteUser(User user) {
       if (users.remove(user))
           System.out.println("User is deleted");
       else
           System.out.println("User is not found");
    }

    @Deprecated
    @Role
    public static void payToUser(Integer id, Double amount) {
        for (User user: users) {
            if (user.getId().equals(id)) {
                user.setBalance(user.getBalance() + amount);
            }
        }
    }

    @Role
    public static void newPayToUser(Integer id, Double amount) {
        users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .ifPresentOrElse(user -> user.setBalance(user.getBalance() + amount),
                        () -> System.out.println("User is not found"));
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                '}';
    }
}
