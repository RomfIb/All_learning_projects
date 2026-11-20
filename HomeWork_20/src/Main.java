//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import Enum.*;
public class Main {
    public static void main(String[] args) {
        String email = "java17@java.com";
        Boolean isValidEmail = email.matches("[a-zA-Z0-9_.]+@[a-zA-Z]+\\.[a-zA-Z]{2,}");
        System.out.println(isValidEmail);
        String mailIndex = "AZ1001";
        Boolean isValidMailIndex = mailIndex.matches("AZ\\d{4}");
        System.out.println(isValidMailIndex);

        User user1 = new User(101,"Alex", "alex1990@mail.com",0.0);
        User user2 = new User(305,"Jack", "jack95@mail.com",1000.0);
        User user3 = new User(704,"John", "john00@mail.com",700.0);
        System.out.println(user2.getEmail());
        User.changeEmailById(305,"newJack@mail.com");
        System.out.println(user2.getEmail());
        User.newPayToUser(101,100.0);
        User.payToUser(101,200.0);
        System.out.println(user1.getBalance());
    }

    public static boolean isValidAge(String ageStr) {
        if (ageStr == null)
            return false;
        if (ageStr.isEmpty() || ageStr.length() > 2)
            return false;
        for (int i = 0; i <= ageStr.length() - 1; i++) {
            if (!Character.isDigit(ageStr.charAt(i)))
                return false;
        }
        int age = Integer.parseInt(ageStr);
        return age >= 0 && age <= 99;
    }

    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        return email.matches("[a-zA-Z0-9_.]+@[a-zA-Z]+\\.[a-zA-Z]{2,}");
    }
}