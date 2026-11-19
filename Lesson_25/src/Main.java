import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        User user1 = new User("Ali", 25, "ali25");
        try(
                FileOutputStream file = new FileOutputStream("user.ser");
                ObjectOutputStream object = new ObjectOutputStream(file)
        ) {
            object.writeObject(user1);
            System.out.println("User saved");
        } catch (IOException e) {
            System.err.println(e.getStackTrace());
        }
        User user = new User();
        user.setName("Samed");
        User.setLastName("Pirvaliyev");
        try(
                FileInputStream file = new FileInputStream("user.ser");
                ObjectInputStream input = new ObjectInputStream(file);
        ) {
            user = (User) input.readObject();
            System.out.println(user);
        }
        catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getStackTrace());
        }
        String count = "0";
//        for (int i = 1; i <= 10_000; i++){
//            count += i;
//        }
        System.out.println(count);
        StringBuilder stringBuilder = new StringBuilder("hello");
        System.out.println(stringBuilder);
        stringBuilder.append(", java");
        System.out.println(stringBuilder);
        StringBuilder builderCount = new StringBuilder("0");
        StringBuilder builderCount1 = new StringBuilder();
        System.out.println(builderCount1.capacity());
        for (int i = 1; i <= 10_000; i++) {
            builderCount.append(i);// в heap меняется один и тот же объект
        }
        System.out.println(builderCount);
        System.out.println(builderCount.length());
        System.out.println(builderCount.capacity());
        stringBuilder.insert(6, " basic");
        System.out.println(stringBuilder);
        stringBuilder.delete(6, 12);
        System.out.println(stringBuilder);
        stringBuilder.deleteCharAt(7);
        System.out.println(stringBuilder);
        stringBuilder.replace(3, 5, "p");
        System.out.println(stringBuilder);
        stringBuilder.reverse();
        System.out.println(stringBuilder);

        StringBuffer stringBuffer = new StringBuffer();   //каждая операция атомарная, безопасно
        double a = 0.512345;
        double b = 0.234561;
        double sum = a + b;
        System.out.println(sum);
        BigDecimal bigA = new BigDecimal("0.512345");
        BigDecimal bigB =new BigDecimal("0.234561");
//        BigDecimal bigSum = bigA.add(bigB);

        BigDecimal bigSum = bigA.divide(bigB,2, RoundingMode.UP);
        System.out.println(bigSum);
        System.out.println(bigSum.scale());
        System.out.println(bigSum.precision());
        BigDecimal hundred = new BigDecimal("100");
        BigDecimal hundred1 = new BigDecimal("100.0");
        BigDecimal hundred2 = new BigDecimal("100.00");
        System.out.println(hundred.equals(hundred1));
        System.out.println(hundred.compareTo(hundred1));
        BigDecimal s = hundred.plus();
        System.out.println(s);
        BigInteger i = new BigInteger("17");
    }
}