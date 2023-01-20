import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lib {

    private static Scanner input = new Scanner(System.in);

    // Запрос числа у пользоватекля
    static int getNumberByUser() {
        System.out.print("Введите число: ");
        return input.nextInt();
    }

    // создание массива
    static int[] createArray(int size, int origin, int bound) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(origin, bound);
        }
        return arr;
    }

    // возвращает массив четных чисел
    static int[] even(int[] arr) {
        int[] buf = new int[0];

        for (int i : arr) {
            if (i % 2 == 0) {
                buf = addToArray(buf, i);
            }
        }
        return buf;
    }

    // добавляет новый элемент в массив
    static int[] addToArray(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    // печать массива
    static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
