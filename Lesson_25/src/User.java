import java.io.Serializable;

public class User implements Serializable {

    private static final Long serialVersionUID = 1L;

    private String name;
    private int age;
    private transient String password;
    private static String lastName = "Valiyev";
    private Adress adress;

    public User() {
    }

    public User(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setLastName(String lastName) {
        User.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
