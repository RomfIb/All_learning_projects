import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
        public static void main(String[] args) {

        BigInteger factorial = new BigInteger("1");
        for (long i = 1; i <= 100; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        System.out.println(factorial);

        BigInteger initialRice = new BigInteger("1");
        for (int i = 1; i <= 64; i++) {
            initialRice = initialRice.multiply(BigInteger.valueOf(2));
        }
        BigInteger riceCount = initialRice.subtract(BigInteger.valueOf(1));
        System.out.println("Rice count on chessboard: " + riceCount);
        BigInteger initialRice2 = new BigInteger("1");
        BigInteger riceCount2 = initialRice2.multiply(BigInteger.valueOf(2)).pow(64).subtract(initialRice2);
        System.out.println("Rice count on chessboard: " + riceCount2);

        BankAccount bankAccount1 = new BankAccount(new BigDecimal("155.7531"));
        BankAccount bankAccount2 = new BankAccount(new BigDecimal("93.7845"));
        BigDecimal sum = bankAccount1.getBalance().add(bankAccount2.getBalance());
        System.out.println(sum);
        BigDecimal scaleRoundUpSum = bankAccount1.getBalance().add(bankAccount2.getBalance()).setScale(2, RoundingMode.UP);
            System.out.println(scaleRoundUpSum);
        BigDecimal scaleRoundDownSum = bankAccount1.getBalance().add(bankAccount2.getBalance()).setScale(2, RoundingMode.DOWN);
            System.out.println(scaleRoundDownSum);
        BigDecimal scaleRoundHalfUpSum = bankAccount1.getBalance().add(bankAccount2.getBalance()).setScale(2, RoundingMode.HALF_UP);
            System.out.println(scaleRoundHalfUpSum);
        BigDecimal scaleRoundHalfDownSum = bankAccount1.getBalance().add(bankAccount2.getBalance()).setScale(2, RoundingMode.HALF_DOWN);
            System.out.println(scaleRoundHalfDownSum);
        BigDecimal scaleRoundHalfEvenSum = bankAccount1.getBalance().add(bankAccount2.getBalance()).setScale(2, RoundingMode.HALF_EVEN);
            System.out.println(scaleRoundHalfEvenSum);
        BigDecimal scaleRoundFloorSum = bankAccount1.getBalance().add(bankAccount2.getBalance()).setScale(2, RoundingMode.FLOOR);
            System.out.println(scaleRoundFloorSum);
        BigDecimal scaleRoundCeilingSum = bankAccount1.getBalance().add(bankAccount2.getBalance()).setScale(2, RoundingMode.CEILING);
        System.out.println(scaleRoundCeilingSum);
        //BigDecimal scaleRoundUnnecessarySum = bankAccount1.getBalance().add(bankAccount2.getBalance()).setScale(2, RoundingMode.UNNECESSARY);
        //    System.out.println(scaleRoundUnnecessarySum);



        BankAccount bankAccount = new BankAccount(
                new BigDecimal("123.45"),
                "+994505050505",
                new Adress("Samad Vurgun", 25));
            System.out.println(bankAccount);
        try(
                FileOutputStream outputFile = new FileOutputStream("bankaccount.ser");
                ObjectOutputStream outputObject = new ObjectOutputStream(outputFile);
        ) {
            outputObject.writeObject(bankAccount);
            System.out.println("Bank account saved");
        }
        catch (IOException e) {
            System.err.println(e.getStackTrace());
        }

        //BankAccount inputBankAccount = new BankAccount();

        try (FileInputStream inputFile = new FileInputStream("bankaccount.ser");
             ObjectInputStream inputObject = new ObjectInputStream(inputFile);
        ){
            BankAccount inputBankAccount = (BankAccount) inputObject.readObject();
            System.out.println(inputBankAccount);
        }
        catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getStackTrace());
        }
    }
}