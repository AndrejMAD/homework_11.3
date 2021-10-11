public class BankAccount {

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

  public boolean take(double amountToTake) {
    if (amountToTake > amount) {
      return false;
    }
    amount -= amountToTake;
    return true;
  }

  public boolean send(BankAccount receiver, double amount) {
    if (take(amount)) {
      receiver.put(amount);
      return true;
    }
    return false;
  }
}