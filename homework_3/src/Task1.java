import java.util.Arrays;
/**
 * Реализовать алгоритм сортировки слиянием.
 */
public class Task1 {
    static public void run(int[] array){
        System.out.println("<<<<<<<<<< Task 1 >>>>>>>>>>");
        System.out.println("===== Исходный массив =====\n" + Arrays.toString(array));

        System.out.println("===== Отсортированный массив =====\n" + Arrays.toString(mergeSort(array)));
    }

public static int[] mergeSort(int[] src) {
    if (src.length <= 1) return src;
    int[] left = Arrays.copyOfRange(src, 0, src.length / 2);
    int[] right = Arrays.copyOfRange(src, left.length, src.length);

    return merge(mergeSort(left), mergeSort(right));
}
    private static int[] merge(int[] left, int[] right) {

        int[] result = new int[left.length + right.length];

        int resIn = 0, leftIn = 0, rightIn = 0;

        while (leftIn < left.length && rightIn < right.length)
            if (left[leftIn] < right[rightIn])
                result[resIn++] = left[leftIn++];
            else result[resIn++] = right[rightIn++];

        while (resIn < result.length)
            if (leftIn != left.length)
                result[resIn++] = left[leftIn++];
            else result[resIn++] = right[rightIn++];

        return result;
    }
}
