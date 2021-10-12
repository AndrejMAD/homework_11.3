public class TopManager extends AbstractEmployee {

    private final double BONUS_FIX_SALARY = 1.5;
    private final int BONUS_MIN_INCOME = 10_000_000;

    public TopManager(int fixSalary) {
        super(fixSalary);
    }

    @Override
    public int getMonthSalary() {
        if (company.getIncome() > BONUS_MIN_INCOME) {
            return (int) (fixSalary * BONUS_FIX_SALARY);
        }
        return fixSalary;
    }
}