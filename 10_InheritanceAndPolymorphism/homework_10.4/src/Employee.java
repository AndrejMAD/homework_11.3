public interface Employee extends Comparable<Employee> {

    public int getMonthSalary();

    public void setCompany(Company company);

    @Override
    default int compareTo(Employee e) {
        return Integer.compare(getMonthSalary(), e.getMonthSalary());
    }
}
