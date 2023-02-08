import java.util.*;

/**
 * Реализуйте структуру телефонной книги с помощью HashMap,
 * учитывая, что один человек может иметь несколько телефонов.
 */
public class Task1 {
    public static void run() {
        Map<String, List<String>> phoneNumbers = new HashMap<>();
        getPhoneNumbers(phoneNumbers, "Иван").
                addAll(Arrays.stream(new String[]{"+7(124)565-46-45", "+7(234)456-45-69"}).toList());

        getPhoneNumbers(phoneNumbers, "Константин").
                addAll(Arrays.stream(new String[]{"+7(686)123-42-32"}).toList());

        getPhoneNumbers(phoneNumbers, "Михаил").
                addAll(Arrays.stream(new String[]{"+7(686)781-23-76", "+7(897)823-40-56", "+7(237)897-89-41"}).toList());

        System.out.println(phoneNumbers);
    }

    public static List<String> getPhoneNumbers(Map<String, List<String>> phoneNumbers, String name) {
        List<String> phones;
        if (!phoneNumbers.containsKey(name)) {
            phoneNumbers.put(name, new ArrayList<>());
        }
        phones = phoneNumbers.get(name);
        return phones;
    }
}
