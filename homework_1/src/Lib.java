import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lib {

    private static final Scanner input = new Scanner(System.in);


    /**
     * <p>Запрос числа у пользоватекля</p>
     *
     * @return число введенное пользователем
     */
    static int getNumberByUser() {
        System.out.print("Введите число: ");
        return input.nextInt();
    }

    /**
     * <p>создание массива случайных чисел</p>
     *
     * @param size   размер массива
     * @param origin нижнаяя граница значений
     * @param bound  верхняя граница значений
     * @return массив случайных чисел
     */
    static int[] createArray(int size, int origin, int bound) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(origin, bound);
        }
        return arr;
    }

    /**
     * <p>добавляет новый элемент в массив</p>
     *
     * @param arr   исходный массив
     * @param value добавляемое значение
     * @return новый массив с добавленным значением
     */
    static int[] addToArray(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }


    /**
     * <p>печать массива</p>
     *
     * @param arr массив значений
     */
    static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}