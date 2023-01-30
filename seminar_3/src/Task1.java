import java.util.*;

/**
 * Заполнить список десятью случайными числами.
 * * Отсортировать список методом sort() и вывести его на экран.
 */
public class Task1 {
    public static void run() {
        List<Integer> list = generateIntList(10, 1, 100);
//      list.sort(null);
        Collections.sort(list);
        System.out.println(list);
    }

    /**
     * <p>создание списока случайных чисел</p>
     *
     * @param size   размер массива
     * @param origin нижнаяя граница значений
     * @param bound  верхняя граница значений
     * @return список случайных чисел
     */
    static List<Integer> generateIntList(int size, int origin, int bound) {
        Random random = new Random();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(origin, bound));
        }
        return list;
    }
}
