import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * <h2>Задача №1</h2>
 * <p>
 *     В файле содержится строка с исходными данными в такой форме:
 *     {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
 *     Требуется на её основе построить и вывести на экран новую строку, в форме SQL запроса:
 *     SELECT * FROM students WHERE name = "Ivanov" AND country = "Russia" AND city = "Moscow";
 *     Для разбора строки используйте String.split. Сформируйте новую строку, используя StringBuilder.
 *     Значения null не включаются в запрос.
 * </p>
 */
public class Task1 {

    public static void run() {
        System.out.println(createSelectStatement(getPerson(), "students"));
    }

    public static String getPerson() {
        File file = Paths.get("person.json").toAbsolutePath().toFile();

        String text;
        try {
            text = Files.readString(file.toPath());

        }catch (java.nio.file.NoSuchFileException e){
            System.out.println("Файл не найден!\n" + e);
            return "";
        } catch (IOException e) {
            System.out.println("При попытке чтения файла произошла ошибка!\n" + e);
            return "";
        }
        return text;
    }

    public static String createSelectStatement(String jsonStr, String from) {
        StringBuilder req = new StringBuilder(String.format("SELECT * FROM %s WHERE", from));

        // массив строк вида "key:value"
        if (jsonStr.length() > 0){
            String[] items = jsonStr
                    .substring(1, jsonStr.length() - 1)
                    .replace("\"", "")
                    .split(",");


            for (int i = 0; i < items.length; i++) {
                String[] keyValues = items[i].strip().split(":");

                if (!keyValues[1].equals("null")) {

                    req.append(" ");
                    req.append(keyValues[0]);
                    req.append(" = \"");
                    req.append(keyValues[1]);
                    req.append("\"");

                    if (i < items.length - 2) {
                        req.append(" AND");
                    }
                }
            }
            req.append(";");
        }
        return req.toString();
    }
}
