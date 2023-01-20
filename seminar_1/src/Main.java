
public class Main {
    public static void main(String[] args) {
        // Дан массив чисел, нужно сформировать новую выборку из только четных чисел
        int[] arr = Lib.createArray(Lib.getNumberByUser(), 0, 100);
        Lib.printArray(arr);
        Lib.printArray(Lib.even(arr));
    }
}

