import java.io.Serializable;
import java.math.BigDecimal;

public class BankAccount implements Serializable{
    private transient BigDecimal balance;
    private String contact;
    private Adress adress;

    public BankAccount() {
    }

    public BankAccount(BigDecimal balance) {
        this.balance = balance;
    }

    public BankAccount(BigDecimal balance, String contact, Adress adress) {
        this.balance = balance;
        this.contact = contact;
        this.adress = adress;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getContact() {
        return contact;
    }

    public Adress getAdress() {
        return adress;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                ", contact='" + contact + '\'' +
                ", adress=" + adress +
                '}';
    }
}
