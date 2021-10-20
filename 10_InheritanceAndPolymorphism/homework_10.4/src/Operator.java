public class Operator extends AbstractEmployee implements Employee {

    protected Operator(int fixSalary) {
        super(fixSalary);
    }

    @Override
    public int getMonthSalary() {
        return fixSalary;
    }
}
