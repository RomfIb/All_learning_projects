public class User {
    private String name;
    private int age;
    private Double salary;

    public static int staticField;

    public static int userCount = 0;


    public User () {

    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, int age, Double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public void setName (String name) {
        if (name.length() > 2) {
            this.name = name;
        }
    }

    public String getName () {
        return this.name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public static void incrementUsercount () {
        userCount++;
    }

    public void addUser () {
        incrementUsercount();
    }

    public boolean equals(User user) {
        return (user.name.equals(this.name)) && (user.age == this.age) && (user.salary.equals(this.salary));
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}