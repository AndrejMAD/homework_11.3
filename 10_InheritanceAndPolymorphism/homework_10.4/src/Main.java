import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final int FIX_SALARY_OPERATOR = 30_000;
    public static final int FIX_SALARY_MANAGER = 40_000;
    public static final int FIX_SALARY_TOP_MANAGER = 50_000;

    public static void main(String[] args) {
        Company company = new Company();

        for (int i = 0; i < 180; i++) {
            company.hire(new Operator(FIX_SALARY_OPERATOR));
        }

        for (int i = 0; i < 80; i++) {
            company.hire(new Manager(FIX_SALARY_MANAGER));
        }

        ArrayList<Employee> topManagers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            topManagers.add(new TopManager(FIX_SALARY_TOP_MANAGER));
        }
        company.hireAll(topManagers);

        printTop(company);
        printLow(company);

        List<Employee> employees = company.getEmployees();
        System.out.println("Количество сотрудников: " + employees.size());
        for (int i = 0; i < employees.size() / 2; i++) {
            company.fire(employees.get(i));
        }
        System.out.println("Уволили 50% сотрудников");
        System.out.println("Количество сотрудников: " + company.getEmployees().size());

        printTop(company);
        printLow(company);
    }

    public static void printTop(Company company) {
        System.out.println("Список из 10–15 самых высоких зарплат в компании:");
        List<Employee> topSalaryStaff = company.getTopSalaryStaff(15);
        for (Employee e : topSalaryStaff) {
            System.out.println(e.getMonthSalary());
        }
    }

    public static void printLow(Company company) {
        System.out.println("Список из 30 самых низких зарплат в компании:");
        List<Employee> lowestSalaryStaff = company.getLowestSalaryStaff(30);
        for (Employee e : lowestSalaryStaff) {
            System.out.println(e.getMonthSalary());
        }
    }
}