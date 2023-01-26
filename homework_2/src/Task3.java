import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <h2>Задача №2</h2>
 * <p>В файле содержится строка с данными:
 * [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
 * {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
 * {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
 * Напишите метод, который разберёт её на составные части,
 * используя StringBuilder создаст массив строк такого вида:
 * Студент Иванов получил 5 по предмету Математика.
 * Студент Петрова получил 4 по предмету Информатика.
 * Студент Краснов получил 5 по предмету Физика.</p>
 */
public class Task3 {
    public static void run() {
//        System.out.println(jsonParse(readFile("grades.json")));
        jsonParse(readFile("grades.json"));
    }

    public static String readFile(String name) {
        File file = Paths.get(name).toAbsolutePath().toFile();

        String text;
        try {
            text = Files.readString(file.toPath());

        } catch (java.nio.file.NoSuchFileException e) {
            System.out.println("Файл не найден!\n" + e);
            return "";
        } catch (IOException e) {
            System.out.println("При попытке чтения файла произошла ошибка!\n" + e);
            return "";
        }
        return text;
    }

    public static String jsonParse(String jsonString) {
//        String regex = "[\\{^\\}^\\s+^\\n^\"\\[\\]]";
        String regex = "\\{[^\\}]*\\}";
        String regexFirst = ".*?\"фамилия\":\"";
        String[] ss = jsonString
                .replaceAll(regex, "")
                .split(",");

//        for (String s : ss) {
//            System.out.println("S = " + s);
//        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(jsonString.substring(1, jsonString.length() - 1));
        while (matcher.find()) {
            String temp = matcher.group(0);
            for (String s:temp.replaceAll("[\\{\\}\\s+\"]", "").split(",")) {
                System.out.println(s);
            }

//            String[] ss = temp.substring(1, temp.length() - 1).split(",");
//            System.out.println("=========");
//            for (String s: ss) {
//                System.out.println(s);
//            }
        }

//        for (String grade : s)

        return jsonString;
    }
}


