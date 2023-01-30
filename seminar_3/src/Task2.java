import java.util.*;

/**
 * Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями.
 * Вывести название каждой планеты и количество его повторений в списке.
 * <p>
 * Доп. Пройти по списку из предыдущего задания и удалить повторяющиеся элементы.
 */
public class Task2 {
    public static void run() {

        List<String> planets = new ArrayList<>();
        List<String> planetsTemp = new ArrayList<>();
        Map<String, Integer> reiterations = new HashMap<>();

        planets.add("Меркурий");
        planets.add("Венера");
        planets.add("Земля");
        planets.add("Земля");
        planets.add("Земля");
        planets.add("Марс");
        planets.add("Юпитер");
        planets.add("Сатурн");
        planets.add("Уран");
        planets.add("Уран");
        planets.add("Нептун");
        planets.add("Плутон");
        planets.add("Плутон");
        planets.add("Плутон");

        for (String planet : planets) {
            if (reiterations.containsKey(planet)) {
                reiterations.put(planet, reiterations.get(planet) + 1);
            } else {
                reiterations.put(planet, 1);
            }

        }
        System.out.println(reiterations);

        // Task2.2
        Iterator<String> planetsIterator = planets.iterator();
        String item;

        while (planetsIterator.hasNext()) {
            item = planetsIterator.next();

            if (planetsTemp.contains(item)) {
                planetsIterator.remove();
            } else {
                planetsTemp.add(item);
            }
        }
        System.out.println(planets);
    }
}
