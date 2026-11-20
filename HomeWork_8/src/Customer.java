public class Customer {
    private String name;
    private int age;
    private int id;
    private BankAccount account;

    public Customer (String alex, int age, int id, Double accountBalance){
    }

    public Customer (String name, int age, int id, BankAccount account) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getId() { return id; }
    public BankAccount getCustomerAccount() {
        return account;
    }
}
