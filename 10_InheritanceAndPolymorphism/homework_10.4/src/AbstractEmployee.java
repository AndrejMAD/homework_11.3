public abstract class AbstractEmployee implements Employee {

    protected Company company;
    protected final int fixSalary;

    public AbstractEmployee(int fixSalary) {
        this.fixSalary = (int) (Math.random() * fixSalary + fixSalary);
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}