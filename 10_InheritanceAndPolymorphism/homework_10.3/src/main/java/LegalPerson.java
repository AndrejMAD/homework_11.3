public class LegalPerson extends Client {

    private final double feeTake = 0.01;

    @Override
    public void take(double amountToTake) {
        super.take(amountToTake + amountToTake * feeTake);
    }

    @Override
    public void printInfo() {
        System.out.println("Баланс: " + getAmount());
        System.out.println("Пополнение: без комиссии");
        System.out.println("Списание: комиссия 1%");
    }
}
