import java.util.*;

import Enum.*;
public class BankOperation {
    private final Deque<Transaction> history = new ArrayDeque<>();

    public void addTransaction(OperationType type, Double amount){
        history.offerLast(new Transaction(type, amount));
    }

    public Transaction getLastTransaction() {
        return history.peekLast();
    }

    public Transaction getFirstTransaction() {
        return history.peekFirst();
    }

    public Transaction removeLastTransaction() {
        return history.pollLast();
    }

    public Map<OperationType, Double> getTotalAmountByType () {
        Map<OperationType, Double> totals = new HashMap<>();
        for (Transaction transaction: history) {
            double currentTotal = totals.getOrDefault(transaction.type(), 0.0);
            totals.put(transaction.type(), currentTotal + transaction.amount());
        }
        return totals;
    }

}
