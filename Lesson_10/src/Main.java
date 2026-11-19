import Exceptions.DivisionByZeroException;
import Exceptions.InvalidAgeException;
import Exceptions.InvalidEmailException;
import Exceptions.InvalidUserNameException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try {
            if (b == 0) {
                //throw new DivisionByZeroException("Cannot be zero");
                throw new IllegalArgumentException("Dont do this");
            }
            System.out.println(a/b);
            //Integer s = Integer.parseInt("java");
        }
        catch (DivisionByZeroException e) {
            System.err.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        catch (IllegalArgumentException e) {
            System.err.println("Wrong value");
        }
//        catch (Exception e) {
//            System.err.println("Wrong");
//        }

        User u5 = new User("Brian", 15, "brian@gmail.com");
        try {
            u5.go();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            //User u1 = new User("Al", -5, "al.gmail.com");
            //User u2 = new User("Alex" , -5, "alex@gmail.com");
            //User u3 = new User("Alex" , 5, "alexgmail.com");
            User u4 = new User("1234567" , 5, "alex@gmail.com");
        }
        catch (InvalidUserNameException e) {
            System.out.println(e.getMessage());
        }
        catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
        catch (InvalidEmailException e) {
            System.out.println(e.getMessage());
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}