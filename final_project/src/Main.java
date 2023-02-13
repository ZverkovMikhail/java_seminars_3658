import java.util.*;
import java.util.stream.Collectors;

/**
 * 1. Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
 * <p>
 * 2. Создать множество ноутбуков.
 * <p>
 * 3. Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
 * отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например:
 * <p>
 * “Введите цифру, соответствующую необходимому критерию:
 * 1 - ОЗУ
 * 2 - Объем ЖД
 * 3 - Операционная система
 * 4 - Цвет …
 * <p>
 * 4. Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации
 * можно также в Map.
 * <p>
 * 5. Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
 */
public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();
        Map<String, Object> criteria = requestCriteria();

        laptops.add(new Laptop(
                "HP", "pavilion-2", "red", "Windows", 3000, 64, 5200)
        );
        laptops.add(new Laptop(
                "HP", "pavilion-1", "black", "linux", 2000, 32, 3200)
        );
        laptops.add(new Laptop(
                "Asus", "Vivobook", "red", "Windows", 3000, 16, 2400)
        );
        laptops.add(new Laptop(
                "Apple", "air", "silver", "macOS", 256, 32, 3200)
        );


        Set<Laptop> filteredLaptops = laptops.stream().
                filter(laptop -> laptop.isMeets(criteria)).collect(Collectors.toSet());

        for (Laptop l : filteredLaptops) {
            System.out.println(l);
        }
    }

    /**
     * Запрашивает критерии фильтрации у пользователя
     * @return словарь критерий фильтрации, ключ соответствует имени getter метода ноутбука
     */
    public static Map<String, Object> requestCriteria() {
        Map<String, Object> criteria = new HashMap<>();
        boolean isNext = true;
        while (isNext) {

            System.out.print(
                    "* 1 - Бренд\n" +
                            "* 2 - Модель\n" +
                            "* 3 - Оперционная система\n" +
                            "* 4 - Объем ОЗУ\n" +
                            "* 5 - Объем HDD\n" +
                            "* 6 - Скорость процессора\n" +
                            "* 7 - Цвет\n" +
                            "* 0 - Завершить ввод критериев поиска\n" +
                            "Введите цифру, соответствующую необходимому критерию: "
            );

            try {
                switch (scanner.nextInt()) {
                    case 0:
                        isNext = false;
                        break;
                    case 1:
                        criteria.put("brand", requestValue("Введите бренд: "));
                        break;
                    case 2:
                        criteria.put("model", requestValue("Введите Модель: "));
                        break;
                    case 3:
                        criteria.put("os", requestValue("Введите Оперционную систему: "));
                        break;
                    case 4:
                        criteria.put("ramSize", Integer.parseInt(requestValue("Введите Объем ОЗУ: ")));
                        break;
                    case 5:
                        criteria.put("hddSize", Integer.parseInt(requestValue("Введите Объем HDD: ")));
                        break;
                    case 6:
                        criteria.put("cpuSpeed", Integer.parseInt(requestValue("Введите Скорость процессора: ")));
                        break;
                    case 7:
                        criteria.put("color", requestValue("Введите Цвет: "));
                        break;
                    default:
                        System.out.println("Вы ввели не правильное знаение!");
                }
            }catch (InputMismatchException e){
                scanner = new Scanner(System.in);
                System.out.println("Значение должно быть числом!");
            }
        }
        return criteria;
    }

    public static String requestValue(String msg) {
        System.out.print(msg);
        return scanner.next();
    }
}

