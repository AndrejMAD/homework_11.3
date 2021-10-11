public class PhysicalPerson extends Client {

    @Override
    public void printInfo() {
        System.out.println("Баланс: " + getAmount());
        System.out.println("Пополнение: без комиссии");
        System.out.println("Списание: без комиссии");
    }
}
