import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Реализовать консольное приложение, которое в цикле:
 * Принимает от пользователя строку вида
 * text~num
 * Нужно разделить строку по ~, сохранить text в связный список на позицию num.
 * Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.
 */
public class Task1 {
    public static void run() {
        List<String> strings = new LinkedList<>();
        while (true) {
            String[] data = requestData();
            if(data.length < 2){
                System.out.println("Вы ввели не корректную строку!");
                continue;
            }
            String text = data[0];
            int index = Integer.parseInt(data[1]);

            if (strings.size() > index) {
                System.out.printf("removed element index %s = %s\n", index, strings.remove(index));
            } else {
                strings.add(index, text);
                System.out.println(strings);
            }
        }
    }

    public static String[] requestData() {
        System.out.print("Введмте строку вида text~num: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().split("~");

    }
}
