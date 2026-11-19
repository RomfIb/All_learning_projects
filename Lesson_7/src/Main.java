//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       // Result r = calculation(5,7);
        //System.out.println(calculationold(5,7));
//        System.out.println(r.sum);
//        System.out.println(r.sub);
//        System.out.println(r.mul);
//        System.out.println(r.div);

        String userName = "Alex";
        int age = 34;

        User u1 = new User(userName, age);
        u1.setSalary(50000.0);
        User u2 = u1;
        User u3 = new User("Alex", 34, 50000.0);


        System.out.println(u1 == u3);
        System.out.println(u1 == u2);
        System.out.println(u1.equals(u3));
        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);
        System.out.println(u1.hashCode());
        System.out.println(u2.hashCode());
        System.out.println(u3.hashCode());
        //u3 = null;
        System.out.println(u3);
        System.out.println(u1.equals(u3));

        User.staticField = 5;
        u1.addUser();
        u2.addUser();
        u3.addUser();
        System.out.println(User.userCount);


        double a = Math.floor(5.567);
    }

//    public static int[] calculationold(int a, int b) {
//        int sum = a + b;
//        int sub = a - b;
//        int mul = a * b;
//        int div = a / b;
//        int[] results = new int[4];
//        results[0] = sum;
//        results[1] = sub;
//        results[2] = mul;
//        results[3] = div;
//    }

//    public static Result calculation(int a, int b) {
//        int sum = a + b;
//        int sub = a - b;
//        int mul = a * b;
//        int div = a / b;
//        Result result = new Result();
//        result.sum = sum;
//        result.sub = sub;
//        result.mul = mul;
//        result.div = div;
//        return result;
//    }

    public static class Result {
        int sum;
        int sub;
        int mul;
        int div;
    }



}