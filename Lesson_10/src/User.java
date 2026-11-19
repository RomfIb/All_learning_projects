import Exceptions.InvalidUserNameException;
import Exceptions.InvalidAgeException;
import Exceptions.InvalidEmailException;
public class User {
    private String name;
    private int age;
    private String email;

    public User(String name, int age, String email) {
        if ((name.length() <= 2) || (name.isEmpty())) {
            throw new InvalidUserNameException("Invalid UserName");
        }
        if (age < 0) {
            throw new InvalidAgeException("Invalid age");
        }
        if ((email.length() <= 2) || !(email.contains("@"))) {
            throw new InvalidEmailException("Invalid email");
        }
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public void go() throws Exception {
        System.out.println("ERROR");
    }
}
