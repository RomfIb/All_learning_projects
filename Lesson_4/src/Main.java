//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//        int i = 1;
//        for (; i <= 100; ) {
//            System.out.println(i);
//            i++;
//        }


//        for (int i = 100; i >= 1; ) {
//            System.out.println(i);
//            i--;
//        }

//                int i = 1;
//        for (; i <= 100; ) {
//            if ((i % 2) == 0)
//                System.out.println(i);
//            i++;
//        }

//        for (int i = 1; i <= 100; i++) {
//            if (i > 10)
//                break;
//            System.out.println(i);
//        }
//
//        for (int i = 1; i <= 100; i++) {
//            if (i == 10)
//                continue;
//            System.out.println(i);
//        }

//        int sum = 0;
//        for (int i = 1; i <= 100; i++) {
//            sum += i;
//        }
//        System.out.println(sum);

//        for (int i = 1; i <= 100; i++) {
//            if (i > 10)
//                break;
//            System.out.println(i);
//        }
//
//        for (int i = 1; ; i++) {
//            System.out.println(i);
//        }

//        int i = 1;
//        while (i <= 100) {
//            System.out.println(i);
//            i++;
//        }

//        int i = 1;
//        do {
//            System.out.println(i);
//            i++;
//        }
//        while (i <= -100);

//        for (int i = 1; i<= 5; i++) {
//            for (int j = 1; j <= 5; j++)
//                System.out.println("i = " + i + ", j = " + j);
//        }

//        for (int i = 1; i<= 10; i++) {
//            for (int j = 1; j <= 10; j++) {
//                System.out.print(i * j + "\t");
//            }
//            System.out.println();
//        }

//
//        for (int i = 1; i<= 5; i++) {
//            for (int j = 1; j <= 5; j++) {
//                if (i > j)
//                    System.out.print("*");
//            }
//            System.out.println();
//        }

//        int factorial = 1;
//        for (int i = 1; i<= 5; i++) {
//            factorial *= i;
//        }
//        System.out.println(factorial);

//        int sum = 0;
//        int digit;
//        int i = 4793;
//        while (i != 0) {
//            digit = i % 10;
//            System.out.println(digit);
//            sum += digit;
//            i = i / 10;
//        }
//        System.out.println(sum);

          int[] heights = {50, 40, 45, 67, 80};
//        System.out.println(heights.length);
//        System.out.println(heights[1]);
//        for (int i = 0; i <= heights.length - 1; i++)
//            System.out.println(heights[i]);

//        int k = 0;
//        while (k <= heights.length -1) {
//            System.out.println(heights[k]);
//            k += 2;
//        }

//        for (int height:heights) {
//            System.out.println(height);
//        }
//
//


//      sum(5, 7);

      String s = "Java";
        System.out.println(s.length());
        System.out.println(s.charAt(0));
        System.out.println(s.charAt(s.length() - 1));

        for (int i = 0; i <= s.length() - 1; i++)
            System.out.println(s.charAt(i));

//        System.out.println(s.);
    }


    public static int sum(int a, int b) {
        System.out.println(a + b);
        return 0;
    }

    public static boolean isEven(int a) {
        return ((a % 2) == 0);
    }

}