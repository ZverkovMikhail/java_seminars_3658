import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Lib {

    private static final Scanner input = new Scanner(System.in);


    /**
     * <p>Запрос числа у пользоватекля</p>
     *
     * @return число введенное пользователем
     */
    static int getNumberByUser() {
        System.out.print("Введите число: ");
        return input.nextInt();
    }

    /**
     * <p>создание массива случайных чисел</p>
     *
     * @param size   размер массива
     * @param origin нижнаяя граница значений
     * @param bound  верхняя граница значений
     * @return массив случайных чисел
     */
    static int[] createArray(int size, int origin, int bound) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(origin, bound);
        }
        return arr;
    }

    /**
     * <p>добавляет новый элемент в массив</p>
     *
     * @param arr   исходный массив
     * @param value добавляемое значение
     * @return новый массив с добавленным значением
     */
    static int[] addToArray(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }


    /**
     * <p>печать массива</p>
     *
     * @param arr массив значений
     */
    static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static Logger getLog(Class name) {
        Logger logger = Logger.getLogger(name.getName());
//        ConsoleHandler ch = new ConsoleHandler();
//        logger.addHandler(ch);
//        SimpleFormatter simpleFormatter = new SimpleFormatter();
//        XMLFormatter xml = new XMLFormatter();
//        ch.setFormatter(simpleFormatter);
        try {

            FileHandler fileHandler = new FileHandler(
                    Paths.get(name.getName() + ".log").toAbsolutePath().toString(),
                    true
            );

            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return logger;
    }


}

class TimeCounter {
    protected long startTime = 0;
    String message = "";

    TimeCounter() {
        startTime = System.currentTimeMillis();
    }

    public long getTimeMillis() {
        return System.currentTimeMillis();
    }

    public long start(String msg) {
        message = msg;
        startTime = getTimeMillis();
        return startTime;
    }

    public long stop() {
        return getTimeMillis() - startTime;
    }

    public void stopAndPrint() {
        System.out.println(message + " " + stop() + " ms");
    }
}