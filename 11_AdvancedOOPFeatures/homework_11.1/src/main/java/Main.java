import java.util.List;

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        sortBySalaryAndAlphabet(staff);

        for (Employee e : staff) {
            System.out.println(e);
        }
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        staff.sort((e1, e2) -> {
            if (Integer.compare(e1.getSalary(), e2.getSalary()) == 0) {
                return e1.getName().compareTo(e2.getName());
            }
            return Integer.compare(e1.getSalary(), e2.getSalary());
        });
    }
}