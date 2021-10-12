public class Operator extends AbstractEmployee {

    protected Operator(int fixSalary) {
        super(fixSalary);
    }

    @Override
    public int getMonthSalary() {
        return fixSalary;
    }
}
