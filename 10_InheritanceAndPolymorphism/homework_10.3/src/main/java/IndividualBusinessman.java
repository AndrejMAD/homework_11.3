public class IndividualBusinessman extends Client {

    private final double feePutLess1000 = 0.01;
    private final double feePutMore1000 = 0.005;

    @Override
    public void put(double amountToPut) {
        if (amountToPut < 1000) {
            super.put(amountToPut - amountToPut * feePutLess1000);
        } else {
            super.put(amountToPut - amountToPut * feePutMore1000);
        }
    }

    @Override
    public void printInfo() {

        System.out.println("Баланс: " + getAmount());
        System.out.println("Пополнение: комиссия 1%, если сумма меньше 1 000 рублей. Комиссия 0,5%, если сумма больше либо равна 1 000 рублей");
        System.out.println("Списание: без комиссии");
    }
}
