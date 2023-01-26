import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        task1();
//        task2();
        task3();
    }

//    Дано четное число N (>0) и символы c1 и c2.
//    Написать метод, который вернет строку длины N, которая состоит из
//    чередующихся символов c1 и c2, начиная с c1.

    public static void task1() {
        int n = 10;
        char c1 = 'a';
        char c2 = 'b';
        System.out.println(getString(n, c1, c2));

    }

    public static String getString(int n, char c1, char c2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                sb.append(c1);
            } else {
                sb.append(c2);
            }
        }
        return sb.toString();
    }

    //    Напишите метод, который сжимает строку.
//    Пример: aaaabbbcdd → a4b3cd2
    public static void task2() {
        String str = "aaaabbbcdd";
        System.out.println(zipString(str));

    }

    public static String zipString(String str) {
        StringBuilder sb = new StringBuilder();

        int count = 1;
        char temp = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == temp) {
                count++;
            } else {
                sb.append(temp);
                if (count > 1) {
                    sb.append(count);
                }
                temp = str.charAt(i);
                count = 1;
            }

        }
        if (count > 1) {
            sb.append(String.valueOf(temp) + count);
        } else {
            sb.append(temp);
        }

        return sb.toString();
    }

    //    Напишите метод, который составит строку, состоящую из 100 повторений слова TEST и метод, который запишет эту
//    строку в простой текстовый файл, обработайте исключения.
    public static void task3() {
        writeToFile(createTestString(getNumberByUser(), getStringByUser()));

    }

    public static String createTestString(int n, String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(text);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    private static final Scanner input = new Scanner(System.in);

    static int getNumberByUser() {
        System.out.print("Введите число: ");
        return input.nextInt();
    }

    static String getStringByUser() {
        System.out.print("Введите строку: ");
        return input.next();
    }

    public static void writeToFile(String text) {
        File file = Paths.get("test.txt").toAbsolutePath().toFile();
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

