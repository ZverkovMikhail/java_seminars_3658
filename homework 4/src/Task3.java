import java.util.*;
/**
 * Напишите постфиксный калькулятор. Пользователь вводит данные и операции в обратной польской записи.
 * Калькулятор вычисляет результат и проверяет, что в стэке получилось единственное число.
 * Например:
 * 5 4 3 - + => 5 1 + => 6
 * Формат сдачи: файл с расширением java или ссылка на гит с подписанными ФИ и номером группы.
 */
public class Task3 {
    public static void run() {
        String[] elements = requestData().split(" ");
        Stack<Integer> nums = new Stack<>();

        for (String el : elements) {

            if (isInteger(el)) {
                nums.push(Integer.parseInt(el));
            } else {
                nums.push(calc(nums.pop(), nums.pop(), el));
            }
        }
        System.out.println(nums.pop());
    }

    public static int calc(int x, int y, String symbol) {
        switch (symbol) {
            case "-" -> {
                return y - x;
            }
            case "+" -> {
                return x + y;
            }
            case "*" -> {
                return x * y;
            }
            case "/" -> {
                return x / y;
            }
        }
        return 0;
    }

    public static boolean isInteger(String s) {
        try {
            int i = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static String requestData() {
        System.out.print("Введите выражение в обратной польской записи: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }
}
