import java.util.*;

/**
 * Пусть дан список сотрудников: Иван, Пётр, Антон и так далее.
 * Написать программу, которая найдет и выведет повторяющиеся
 * имена с количеством повторений. Отсортировать по убыванию
 * популярности.
 */
public class Task2 {
    public static void run() {
        List<String> nameList = new ArrayList<>();
        Map<String, Integer> nameCounts = new HashMap<>();

        nameList.add("Иван");
        nameList.add("Пётр");
        nameList.add("Иван");
        nameList.add("Пётр");
        nameList.add("Иван");
        nameList.add("Михаил");
        nameList.add("Иван");
        nameList.add("Антон");
        nameList.add("Иван");
        nameList.add("Михаил");
        nameList.add("Константин");
        nameList.add("Михаил");
        nameList.add("Кирилл");

        for (String name : nameList) {
            int count = nameCounts.getOrDefault(name, 0);
            nameCounts.put(name, ++count);
        }

        List<Map.Entry<String, Integer>> result = nameCounts.
                entrySet().
                stream().
                sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).
                toList();

        for (Map.Entry<String, Integer> e : result)
            System.out.println(e);
    }
}
