import java.util.List;

/**
 * Пусть дан произвольный список целых чисел. Удалить из него чётные числа.
 */
public class Task2 {
    static public void run(List<Integer> list) {
        System.out.println("<<<<<<<<<< Task 2 >>>>>>>>>>");
        System.out.println("===== Исходный Список =====\n" + list);
        list.removeIf(el -> el % 2 == 0);
        System.out.println("===== Список нечетных чисел =====\n" + list);

    }
}
