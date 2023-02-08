import java.util.*;

/**
 * Реализовать алгоритм пирамидальной сортировки (HeapSort).
 */
public class Task3 {
    public static void run() {
        int[] arr = createArray(10, 0, 10);
        System.out.println("++++ Исходный массив ++++\n" + Arrays.toString(arr));

        HeapSort(arr);
        System.out.println("++++ Отсортированный массив ++++\n" + Arrays.toString(arr));
    }

    /**
     * <p>Сортирует массив методом HeapSort</p>
     *
     * @param arr сортеруемый массив
     */
    public static void HeapSort(int[] arr) {
        int size = arr.length;
        int temp;

        // создание сортирующего дерева
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(arr, size, i);
        }

        // корень дерева является самым максимальным элементом
        // на куждом шагу уменьшаем размер дерева, меняя первый элемент с последним
        for (int i = size - 1; i >= 0; i--) {
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // востанавливаем сортирующее дерево
            heapify(arr, i, 0);
        }
    }

    /**
     * <p>приводит массив к состоянию сортирующего дерева</p>
     *
     * @param arr  сортеруемый массив
     * @param size текущий размер дерева
     * @param i    индекс текущего элемента дерева
     */
    private static void heapify(int[] arr, int size, int i) {
        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        // определяем максимальный элемент узла
        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }

        // если максимальный элемент не родительский, меняем местами
        // максимальный элемент родительским
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // востанавливаем сортирующее дерево
            heapify(arr, size, largest);
        }
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
}
