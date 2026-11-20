import com.sun.source.tree.BinaryTree;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        for (int i = 1; i <= 5; i++) {
//            for (int j = 1; j <= 5; j++) {
//                if ((i + j) > 5)
//                    System.out.print("* ");
//                else
//                    System.out.print(" ");
//            }
//            System.out.println();
//        }

//        System.out.println("Enter number: ");
//        int num = scanner.nextInt();
//        int reverse = 0;
//        int digit;
//        while (num != 0) {
//            digit = num % 10;
//            reverse = reverse * 10 + digit;
//            num = num / 10;
//        }
//        System.out.println(reverse);
//
//        double[] array = {50, 40, 45, 67, 80};
//        double avr;
//        double sum = 0;
//        double max = array[0];
//        double min = array[0];
//        for (int i = 0; i <= array.length - 1; i++) {
//            sum += array[i];
//            if (max < array[i])
//                max = array[i];
//            if (min > array[i])
//                min = array[i];
//        }
//        avr = sum / array.length;
//
//        System.out.println("Average value = " + avr);
//        System.out.println("Sum value = " + sum);
//        System.out.println("Maximum value = " + max);
//        System.out.println("Minimum value = " + min);

//        reverseText("hello, Rauf");

//        String word = "level";
//        System.out.println(isPalindrom(word));

//        java("Java");

//        System.out.println(subtract(7, 9));
//        System.out.println(multiply(7, 9));
//        System.out.println(divide(7, 9));
//
//        double[] array = {1, -7, 6, 0, 9, -15};
//        arraySign(array);

//        System.out.println("Average = " + avrElement(array));
//
//        String text = "Hello, my name is Rauf!";
//        System.out.println("Count of characters = " + charCount(text));
    }

    public static int reverseText(String text) {
        String reverse = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            //System.out.print(text.charAt(i));
            reverse += text.charAt(i);
        }
        System.out.println(reverse);
        return 0;
    }

    public static boolean isPalindrom(String word) {
        if (word.length() <= 1)
            return true;
        if (word.charAt(0) != word.charAt(word.length() - 1))
            return false;
        String newWord = "";
        for (int i = 1; i <= word.length() - 2; i++)
                newWord += word.charAt(i);
        return isPalindrom(newWord);
    }


    public static void java(String word) {
        int count = 0;
        for (int i = 0; i <= word.length() - 1; i++) {
            if (word.charAt(i) == 'a')
            count += 1;
        }
        System.out.println("Word has " + count + " A");
    }

    private static double subtract(double minued, double subtrahend) {
        return (minued - subtrahend);
    }

    private static double multiply(double multiplier1, double multiplier2) {
        return (multiplier1 * multiplier2);
    }

    private static double divide(double dividend, double divisor) {
        if (divisor == 0) {
            System.out.println("Divisor cannot be 0!");
            return 0;
        }
        return (dividend / divisor);
    }

    private static void arraySign(double[] array){
        int countPos = 0;
        int countNeg = 0;
        int count0 = 0;
        for (int i = 0; i <= array.length - 1; i++) {
            if (array[i] > 0)
                countPos += 1;
            if (array[i] < 0)
                countNeg += 1;
            if (array[i] == 0)
                count0 += 1;
        }
        System.out.println("Array has " + countPos + " positive elements");
        System.out.println("Array has " + countNeg + " negative elements");
        System.out.println("Array has " + count0 + " null elements");
    }

    private static double avrElement(double[] array) {
        double sum = 0;
        for (int i = 0; i <= array.length - 1; i++) {
            sum += array[i];
        }
        return (sum / array.length);
    }

    private static int charCount(String text) {
        int count = 0;
        for (int i = 0; i <= text.length() - 1; i++)
            count += 1;
        return count;
    }
}