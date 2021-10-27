import java.util.*;

/**
 * Если в качестве ключа выбрать Имя, то имена будут уникальны, а номера могут повторятся,
 * следовательно один номер телефона может принадлежать несколькм именам.
 *
 * В качестве ключа буду использовать номер телефона, т.к. номер телефона может принадлежать
 * только одному имени, а у одного имени может быть несколько номеров.
 */

public class PhoneBook {

    private final Map<String, String> items = new TreeMap<>();

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона (отдельные методы для проверки)
        // если такой номер уже есть в списке, то перезаписать имя абонента
        if (validatePhone(phone).isEmpty() || validateName(name).isEmpty()) {
            return;
        }

        items.put(phone, name);
    }

    public String getContactByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        String name = items.get(phone);
        if (name == null) {
            return "";
        }
        String contact = name + " - " + phone;
        return contact;
    }

    public Set<String> getContactByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        TreeSet<String> allContacts = new TreeSet<>();

        List<String> phones = new ArrayList<>();
        for (Map.Entry<String, String> entry : items.entrySet()) {
            if (name.equals(entry.getValue())) {
                phones.add(entry.getKey());
            }
        }

        if (!phones.isEmpty()) {
            String contact = name + " - " + listToString(phones);
            allContacts.add(contact);
        }

        return allContacts;
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        TreeSet<String> allContacts = new TreeSet<>();

        for (String name : items.values()) {
            List<String> phones = new ArrayList<>();
            for (Map.Entry<String, String> entry : items.entrySet()) {
                if (name.equals(entry.getValue())) {
                    phones.add(entry.getKey());
                }
            }
            String contact = name + " - " + listToString(phones);
            allContacts.add(contact);
        }

        return allContacts;
    }

    public String validateName(String name) {
        String regex = "[а-яА-я- ]+";
        String validateName = name.trim();

        if (!validateName.matches(regex)) {
            return "";
        }

        return validateName;
    }

    public String validatePhone(String phone) {
        String regex = "[^0-9]";
        String validatePhone = phone.replaceAll(regex, "");

        if (validatePhone.isEmpty()) {
            return "";
        }
        if (validatePhone.length() == 10) {
            validatePhone = '7' + validatePhone;
        }
        if (validatePhone.length() != 11) {
            return "";
        }
        if (validatePhone.charAt(0) == '8') {
            validatePhone = '7' + validatePhone.substring(1, validatePhone.length());
        }

        return validatePhone;
    }

    private String listToString(List list) {
        String str = "";
        String split = ", ";

        for (int i = 0; i < list.size(); i++) {
            str = str.concat(list.get(i).toString());
            if (i < list.size() - 1) {
                str = str.concat(split);
            }
        }

        return str;
    }
    // для обхода Map используйте получение пары ключ->значение Map.Entry<String,String>
    // это поможет вам найти все ключи (key) по значению (value)
    /*
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения ключа
        }
    */
}