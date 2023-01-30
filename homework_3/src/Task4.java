import java.util.*;

/**
 * (Необязательная задача повышенной сложности)
 * Даны два ArrayList из целых чисел. Написать функции, которые вычисляют разницу коллекций:
 * Разность:
 * A - B = все числа из первой коллекции, которые не содержатся во второй коллекции
 * B - A = все числа из второй коллекции, которые не содержатся в первой
 * Симметрическая разность:
 * A ^ B = числа из первой коллекции, которых нет во второй, А ТАКЖЕ числа из второй, которых нет в первой
 */
public class Task4 {
    public static void run(List<Integer> list1, List<Integer> list2){
        System.out.println("<<<<<<<<<< Task 4 >>>>>>>>>>");
        System.out.println("===== Исходный Список #1 =====\n" + list1);
        System.out.println("===== Исходный Список #2 =====\n" + list2);
        System.out.println("A - B => " + subtract(list1, list2));
        System.out.println("B - A => " + subtract(list2, list1));
        System.out.println("A ^ B => " + symmetricDifference(list1, list2));
    }
    public static List<Integer> symmetricDifference(List<Integer> list1, List<Integer> list2){
        List<Integer> list = new ArrayList<>();
        list.addAll(subtract(list1, list2));
        list.addAll(subtract(list2, list1));
        return list;
    }
    public static List<Integer> subtract(List<Integer> list1, List<Integer> list2){
        return new HashSet<>(list1).stream().filter(i-> !list2.contains(i)).toList();
    }

}
