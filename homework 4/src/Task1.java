import java.util.LinkedList;
import java.util.List;

/**
 * Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
 */
public class Task1 {
    public static void run() {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(invertList(list));
    }

    private static List<Integer> invertList(List<Integer> list) {
        Integer temp;
        for (int i = 0; i < list.size()/2; i++) {
            temp = list.get(i);
            list.set(i, list.get(list.size()-1-i));
            list.set(list.size()-1-i, temp);
        }
        return list;
    }
}
