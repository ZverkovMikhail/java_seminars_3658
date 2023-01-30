import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *Создать список типа ArrayList<String>.
 * Поместить в него как строки, так и целые числа.
 * Пройти по списку, найти и удалить целые числа.
 */
public class Task3 {
    public static void run(){

        List list = new ArrayList();

        list.add("Меркурий");
        list.add("Венера");
        list.add("Земля");
        list.add(2);
        list.add(1);
        list.add("Марс");
        list.add("Юпитер");
        list.add("Сатурн");
        list.add("Уран");
        list.add(4);
        list.add("Нептун");
        list.add("Плутон");
        list.add(7);
        list.add(8);
        System.out.println(list);

        list.removeIf(el-> el instanceof Integer);
        System.out.println(list);
    }
}
