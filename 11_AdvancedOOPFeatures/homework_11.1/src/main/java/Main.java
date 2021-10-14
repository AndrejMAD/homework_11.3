import java.util.List;
import java.util.function.Consumer;

/*
    Поигравшись с разными способомами передачи кода (аномный класс, лямда, ссылка на метод, итд), пришол к выводу,
    что самый красивый и читаемый код будет:

    в случае с простым кодом, небольшим количеством строк и не требуется повторное использование -
    это лямбда выражение staff.forEach(System.out::println);,

    вслучае со сложным кодом, большим количеством строк и необходимостью повторного использования -
    это реализация в отдельном методе, а метод передавать по ссылке staff.forEach(System.out::println);.
 */

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        sortBySalaryAndAlphabet(staff);

        System.out.println("****************************************");
        staff.forEach(new Consumer<Employee>() {
            @Override
            public void accept(Employee employee) {
                System.out.println(employee);
            }
        });
        System.out.println("****************************************");
        Consumer<Employee> consumerPrint = new ConsumerPrint();
        staff.forEach(consumerPrint);
        System.out.println("****************************************");
        Consumer<Employee> consumer = e -> System.out.println(e);
        staff.forEach(consumer);
        System.out.println("****************************************");
        staff.forEach(System.out::println); //))))))))))))))))))))))))
        System.out.println("****************************************");
        staff.forEach(e -> System.out.println(e)); //)))))))))))))))))
        System.out.println("****************************************");
        Consumer<Employee> consumerMethod = System.out::println;
        for (Employee e : staff) {
            consumerMethod.accept(e);
        }
        System.out.println("****************************************");
        consumer = e -> System.out.println(e);
        for (Employee e : staff) {
            consumer.accept(e);
        }
        System.out.println("****************************************");
        consumerPrint = new ConsumerPrint();
        for (Employee e : staff) {
            consumerPrint.accept(e);
        }
        System.out.println("****************************************");
        for (Employee e : staff) {
            System.out.println(e);
        }
        System.out.println("****************************************");
        for (int i = 0; i < staff.size(); i++) {
            System.out.println(staff.get(i));
        }
        System.out.println("****************************************");
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        // Красота )))
        staff.sort(Main::compareBySalaryAndAlphabet);
    }
    
    public static int compareBySalaryAndAlphabet(Employee e1, Employee e2) {
        if (Integer.compare(e1.getSalary(), e2.getSalary()) == 0) {
            return e1.getName().compareTo(e2.getName());
        }
        return Integer.compare(e1.getSalary(), e2.getSalary());
    }
}