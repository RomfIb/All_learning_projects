public class Manager extends Employee {
    private String name;
    private int age;
    private Double salary;

    public Manager () {

    }

    public Manager (String name, int age, Double salary) {
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

    public void setAge (int age) {
        if (age > 0)
            this.age = age;
    }

    public int getAge () {
        return this.age;
    }

    public void setSalary (Double salary) {
        this.salary = salary;
    }

    public Double getSalary () {
        return this.salary;
    }
}
