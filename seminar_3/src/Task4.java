import java.util.ArrayList;
import java.util.List;

/**
 * Каталог товаров книжного магазина сохранен в виде двумерного списка List<ArrayList<String>> так,
 * что на 0-й позиции каждого внутреннего списка содержится название жанра, а на остальных
 * позициях - названия книг. Напишите метод для заполнения данной структуры.
 */
public class Task4 {
    public static void run() {
        List<List<String>> catalog = new ArrayList<>();

        addToCatalog(catalog, "Фантастика", "Солярис");
        addToCatalog(catalog, "Фантастика", "Эдем");
        addToCatalog(catalog, "Фантастика", "Дюна");
        addToCatalog(catalog, "Комедия", "Двенадцать стульев");
        addToCatalog(catalog, "Комедия", "Уникальный экземпляр");
        System.out.println(catalog);
    }

    public static void addToCatalog(List<List<String>> catalog, String genre, String bookName){
        for (List<String> g: catalog) {
            System.out.println("2");
            if (g.get(0).equalsIgnoreCase(genre)){
                g.add(bookName);
                return;
            }
        }
        System.out.println("2");
        List<String> genreList = new ArrayList<>();
        genreList.add(genre);
        genreList.add(bookName);
        catalog.add(genreList);
    }

}
