//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Console6 {
    public static void main(String[] args) {
//        for (int i = 0; i <= args.length - 1; i++)
//            System.out.println("Hello, " + args[i]);
        if (args.length <= 0)
            return;
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println(a + b);
    }
}