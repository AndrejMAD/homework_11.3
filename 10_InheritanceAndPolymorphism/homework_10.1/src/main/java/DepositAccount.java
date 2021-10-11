import java.time.LocalDate;

public class DepositAccount extends BankAccount {

    private LocalDate lastIncome;

    @Override
    public void put(double amountToPut) {
        lastIncome = LocalDate.now();
        super.put(amountToPut);
    }

    @Override
    public boolean take(double amountToTake) {
        if (LocalDate.now().isAfter(lastIncome.plusMonths(1))) {
            return super.take(amountToTake);
        }
        return false;
    }
}
