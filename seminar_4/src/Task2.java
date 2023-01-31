import java.util.Scanner;
import java.util.Stack;

/**
 * Реализовать консольное приложение, которое:
 * Принимает от пользователя и “запоминает” строки.
 * Если введено print, выводит строки в обратном порядке (первая введённая окажется последней выведенной).
 * Если введено revert, удаляет предыдущую введенную строку из памяти.
 */
public class Task2 {
    public static void run() {
        boolean isWork = true;
        Stack<String> stack = new Stack<>();
        final String printCmd = "print";
        final String revertCmd = "revert";
        final String exitCmd = "exit";
        System.out.printf(
                "Команды:\n" +
                " %s - Печать\n" +
                " %s - Удалить последнюю строку\n" +
                " %s - выход из программы\n\n ",
                printCmd,
                revertCmd,
                exitCmd
        );

        while (isWork) {
            String data = requestData();
            switch (data.toLowerCase()) {
                case printCmd -> {
                    while (!stack.empty()) {
                        System.out.println(stack.pop());
                    }
                }
                case revertCmd -> stack.pop();
                case exitCmd -> isWork = false;
                default -> stack.push(data);
            }
        }

    }

    public static String requestData() {
        System.out.print("Введите строку: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }
}
