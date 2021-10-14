import java.util.function.Consumer;

public class ConsumerPrint implements Consumer<Employee> {
    @Override
    public void accept(Employee employee) {
        System.out.println(employee);
    }
}
