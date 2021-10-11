public abstract class Client {

    private double amount = 0.0;

    public double getAmount() {
        return amount;
    }

    public void put(double amountToPut) {
        if (amountToPut < 0) {
            return;
        }
        amount += amountToPut;
    }

    public void take(double amountToTake) {
        if (amountToTake < 0 || amountToTake > amount) {
            return;
        }
        amount -= amountToTake;
    }

    abstract public void printInfo();
}
