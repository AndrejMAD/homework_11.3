public class CardAccount extends BankAccount {

    private final double takeFee = 0.01;

    @Override
    public boolean take(double amountToTake) {
        return super.take(amountToTake + amountToTake * takeFee);
    }
}
