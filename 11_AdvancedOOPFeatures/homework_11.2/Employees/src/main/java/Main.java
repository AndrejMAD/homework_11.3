import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);
    }

    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {
        Optional<Employee> max = staff.stream()
                .filter(e -> e.getWorkStart().getYear() + 1900 == year)
                .max(Comparator.comparing(e -> e.getSalary()));
        if (max.isPresent()) {
            return max.get();
        }
        return null;
    }
}