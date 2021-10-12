public class Manager extends AbstractEmployee {

    private final double BONUS = 0.05;
    private final int sales;

    public Manager(int fixSalary) {
        super(fixSalary);
        sales = (int) (Math.random() * (140000 - 115000) + 115000);
    }

    public int getSales() {
        return sales;
    }

    @Override
    public int getMonthSalary() {
        return (int) (fixSalary + sales * BONUS);
    }
}