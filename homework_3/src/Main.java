import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = createArray(20, 0, 100);
        Task1.run(array);
        Task2.run(generateIntList(20, 0, 100));
        Task3.run(generateIntList(20, 0, 100));
        Task4.run(
                generateIntList(10, 0, 10),
                generateIntList(10, 0, 10)
        );
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
     * <p>создание списока случайных чисел</p>
     *
     * @param size   размер массива
     * @param origin нижнаяя граница значений
     * @param bound  верхняя граница значений
     * @return список случайных чисел
     */
    static ArrayList<Integer> generateIntList(int size, int origin, int bound) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(origin, bound));
        }
        return list;
    }
}