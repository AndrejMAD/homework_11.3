import java.util.*;

public class EmailList {

    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    private final Set<String> set = new TreeSet<>();

    public void add(String email) {
        // TODO: валидный формат email добавляется
        if (validate(email)) {
            set.add(email.toLowerCase());
            System.out.println("В конец списка был добавлен email: " + email);
        }
    }

    public List<String> getSortedEmails() {
        // TODO: возвращается список электронных адресов в алфавитном порядке
        return new ArrayList<>(set);
    }

    public boolean validate(String email) {
        String emailRegex = "[a-zA-Z.0-9]+[@][a-zA-Z.0-9]+[.][a-zA-Z0-9]+";

        if (!email.matches(emailRegex)) {
            System.out.println(WRONG_EMAIL_ANSWER);
            return false;
        }
        return true;
    }
}