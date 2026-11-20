//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String userName = "Alex";
        int age = 34;

        User u1 = new User(userName, age);
        u1.setSalary(50000.0);
        User u2 = u1;
        User u3 = new User("Alex", 34, 50000.0);


//
//        System.out.println(u1 == u3);
//        System.out.println(u1 == u2);
//        System.out.println(u1.equals(u3));
//        System.out.println(u1);
//        System.out.println(u2);
//        System.out.println(u3);
//        System.out.println(u1.hashCode());
//        System.out.println(u2.hashCode());
//        System.out.println(u3.hashCode());
//        //u3 = null;
//        System.out.println(u3);
//        System.out.println(u1.equals(u3));
//
//        User.staticField = 5;
//        u1.addUser();
//        u2.addUser();
//        u3.addUser();
//        System.out.println(User.userCount);


//        double a = Math.floor(5.567);
//
//        User u4 = new User("George",45,
//                75000.0, new BankAccount("BIR23456", 1470.0));
//
//        System.out.println(u4.getBankAccount().getAccountNumber() + " " + u4.getBankAccount().getAccountBalance());
//        u4.getBankAccount().deposit(1650.9);
//        System.out.println(u4.getBankAccount().getAccountBalance());
//        u4.getBankAccount().widthraw(3090.7);
//        System.out.println(u4.getBankAccount().getAccountBalance());
//
//        Mathematics math = new Mathematics();
//
//        double a = 6.3;
//        int b = 3;
//        double result = math.divide(a,b);
//        System.out.println(result);
//
//        final double pi = 3.14;

        //pi = 5;

        Employee employee = new Employee();
        employee.work();
        Developer developer = new Developer();
        developer.work();
        Employee developer2 = new Developer();
        developer2.work();

        //upcasting
        Developer developer3 = new Developer();
        Employee employee3 = developer3;
        employee3.work();

        //downcasting
        Employee employee4 = new Developer();
        Developer developer4 = (Developer) employee4;
        employee4.work();

        System.out.println(employee4 instanceof Developer);

//        Employee2 employee7 = new Employee2() {
//            @Override
//            public int hashCode() {
//                return super.hashCode();
//            }
//
//            @Override
//            public boolean equals(Object obj) {
//                return super.equals(obj);
//            }
//
//            @Override
//            protected Object clone() throws CloneNotSupportedException {
//                return super.clone();
//            }
//
//            @Override
//            public String toString() {
//                return super.toString();
//            }
//
//            @Override
//            protected void finalize() throws Throwable {
//                super.finalize();
//            }
//        }
//
//        EmployeeInterface developer5 = new Developer2();
//        //developer5.work();
//
//        dowork(developer5);
//        developer5 = new Designer2();
//        //developer5.work();
//
//        dowork(developer5);
//
//        Car car = new Car();
//        car.start();
//    }
//
//
//    public static void dowork (EmployeeInterface e) {
//        e.work();

        BankAccount account1 = new BankAccount("123", 3000.0);
        try {
            account1.widthraw(10000.0);
        }
        catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}