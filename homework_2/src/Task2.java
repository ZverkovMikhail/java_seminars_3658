import java.io.IOException;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.logging.*;

/**
 * <h2>Задача №2</h2>
 * <p>Реализуйте алгоритм сортировки пузырьком числового массива,
 * результат после каждой итерации запишите в лог-файл.</p>
 */
public class Task2 {
    public static void run() {
        int[] arr = generateIntArray(10, 0, 100);
        System.out.println("+++++ Исходный массив +++++\n" + Arrays.toString(arr));

        System.out.println(
                "+++++ Отсортированный массив +++++\n" +
                        Arrays.toString(bubbleSort(arr, createLogger("bubbleSort")))
        );
    }

    /**
     * <p>создание массива случайных чисел</p>
     *
     * @param size   размер массива
     * @param origin нижнаяя граница значений
     * @param bound  верхняя граница значений
     * @return массив случайных чисел
     */
    static int[] generateIntArray(int size, int origin, int bound) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(origin, bound);
        }
        return arr;
    }

    /**
     * <p>Сортировка пузырьком</p>
     *
     * @param array исходный массив
     * @param log логгер для отслеживания процесса сортировки
     * @return отсортированный массив
     */
    static int[] bubbleSort(int[] array, Logger log) {
        int temp;
        boolean isSorted;
        int stepCount;
        int passCount = 0;
        log.info(String.format("Original array => %s", Arrays.toString(array)));
        for (int i = 0; i < array.length; i++) {
            passCount++;
            stepCount = 1;
            isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {

                log.info(String.format(
                                "pass %s step %s => arr[%s]=%s arr[%s]=%s",
                                passCount, stepCount, j, array[j], j + 1, array[j + 1]
                        )
                );

                if (array[j] > array[j + 1]) {
                    isSorted = false;
                    log.info(String.format("swap %s < %s", array[j + 1], array[j]));
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                stepCount++;
            }
            if (isSorted) break;
        }
        log.info(String.format("Sorted array => %s", Arrays.toString(array)));

        return array;
    }
    /**
     * <p>Создание логгера</p>
     *
     * @param name имя лог файла
     * @return Logger
     */
    public static Logger createLogger(String name) {
        Logger logger = Logger.getLogger(name);
        try {

            FileHandler fileHandler = new FileHandler(
                    Paths.get(name + ".log").toAbsolutePath().toString(),
                    true
            );

            fileHandler.setFormatter(new MyFormatter());
            logger.addHandler(fileHandler);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return logger;
    }
}

/**
 * <p>Formatter для логгера</p>
 */
class MyFormatter extends Formatter {
    private static final DateFormat df = new SimpleDateFormat("hh:mm:ss.SSSS");


    public String format(LogRecord record) {
        StringBuilder builder = new StringBuilder(1000);
        builder.append("[").append(record.getLevel()).append("] - ");
        builder.append(record.getSourceClassName()).append(".");
        builder.append(record.getSourceMethodName()).append(" - ");
        builder.append(df.format(new Date(record.getMillis()))).append(" - ");

        builder.append(formatMessage(record));
        builder.append("\n");
        return builder.toString();
    }
}