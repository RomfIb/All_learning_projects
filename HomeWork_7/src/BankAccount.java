public class BankAccount {

    //private String accountOwnerName;
    private Double accountBalance;
    private String accountNumber;

    public BankAccount () {

    }

//    public BankAccount (String accountOwnerName, String accountNumber, Double accountBalance) {
//        this.accountOwnerName = accountOwnerName;
//        this.accountNumber = accountNumber;
//        this.accountBalance = accountBalance;
//    }


    public BankAccount (String accountNumber, Double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public void deposit (Double sum) {
        accountBalance += sum;
        System.out.println("You deposited " + sum);
    }

    public void widthraw (Double sum) {
        if (sum > accountBalance) {
            //System.out.println("Sum cannot be more than current balance!");
            throw new InsufficientBalanceException("Not enough money");
        }
        else {
            accountBalance -= sum;
            System.out.println("You widthrawed " + sum);
        }
    }

//    public String getAccountOwnerName () {
//        return accountOwnerName;
//    }

    public String getAccountNumber () {
        return accountNumber;
    }

    public Double getAccountBalance () {
        return accountBalance;
    }
}
