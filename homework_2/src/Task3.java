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
        for (String line : gradesParse(readFile("grades.json"))) {
            System.out.println(line);
        }
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

    public static String[] gradesParse(String jsonString) {
        Pattern gradePattern = Pattern.compile("\\{[^\\}]*\\}");
        Pattern fieldPattern = Pattern.compile("\"(.+?)\":\"(.+?)\"+");

        Matcher grades = gradePattern.matcher(jsonString.replace(" ",""));
        Matcher fieldsMatcher;

        StringBuilder stringBuilder = new StringBuilder();
        String lastName;
        String grade;
        String lesson;

        while (grades.find()) {
            fieldsMatcher = fieldPattern.matcher(grades.group());
            lastName = "";
            grade = "";
            lesson = "";

            while (fieldsMatcher.find()) {

                switch (fieldsMatcher.group(1).toLowerCase()) {
                    case "фамилия" -> lastName = fieldsMatcher.group(2);
                    case "оценка" -> grade = fieldsMatcher.group(2);
                    case "предмет" -> lesson = fieldsMatcher.group(2);
                }
            }
            stringBuilder
                    .append("Студент ").append(lastName)
                    .append(" получил ").append(grade)
                    .append(" по предмету ").append(lesson)
                    .append("\n");
        }

        return stringBuilder.toString().split("\n");
    }
}


