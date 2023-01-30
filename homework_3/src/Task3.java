import java.util.ArrayList;
import java.util.Collections;

/**
 * Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметичское этого списка.
 */
public class Task3 {
    static public void run(ArrayList<Integer> list) {
        System.out.println("<<<<<<<<<< Task 3 >>>>>>>>>>");
        System.out.println("===== Исходный Список =====\n" + list);
        System.out.println("минимальное = " + Collections.min(list));
        System.out.println("максимальное = " + Collections.max(list));
        System.out.println("среднее арифметичское = " + list.stream() .mapToInt(a -> a).average().orElse(0));
    }
}
