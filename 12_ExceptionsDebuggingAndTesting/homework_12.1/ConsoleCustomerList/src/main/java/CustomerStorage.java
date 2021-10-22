import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new IllegalArgumentException("Данные не соответствуют формату [NAME SURNAME EMAIL PHONE]");
        }
        if (!validateEmail(components[INDEX_EMAIL])) {
            throw new IllegalArgumentException("Не верный формат Email");
        }
        if (!validateTelephoneNumber(components[INDEX_PHONE])) {
            throw new IllegalArgumentException("Не верный формат номера телефолна");
        }

        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }

    private boolean validateTelephoneNumber(String number) {
        String numberRegex = "[^0-9]";

        String formatNumber = number.replaceAll(numberRegex, "");
        if (formatNumber.isEmpty()) {
            return false;
        }
        if (formatNumber.charAt(0) == '8') {
            formatNumber = "7" + formatNumber.substring(1, formatNumber.length());
        }
        if (formatNumber.length() == 10) {
            formatNumber = "7" + formatNumber;
        }
        if (formatNumber.length() != 11 || formatNumber.charAt(0) != '7') {
            return false;
        }

        return true;
    }

    private boolean validateEmail(String email) {
        String emailRegex = "[a-zA-Z.0-9]+[@][a-zA-Z.0-9]+[.][a-zA-Z0-9]+";

        if (email.matches(emailRegex)) {
            return true;
        }

        return false;
    }
}