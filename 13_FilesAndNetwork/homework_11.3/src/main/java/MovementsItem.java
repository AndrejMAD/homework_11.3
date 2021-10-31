public class MovementsItem {

    // Доходы
    private double Income;
    // Расходы
    private double Expense;
    // Операция
    private String organization;

    public MovementsItem(double income, double expense, String organization) {
        Income = income;
        Expense = expense;
        this.organization = organization;
    }

    public double getIncome() {
        return Income;
    }

    public void setIncome(double income) {
        Income = income;
    }

    public double getExpense() {
        return Expense;
    }

    public void setExpense(double expense) {
        Expense = expense;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}
