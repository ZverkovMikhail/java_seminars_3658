import java.util.*;

/**
 * 1) Написать метод, который принимает массив элементов, помещает их в стэк и выводит на консоль содержимое стэка.
 * 2) Написать метод, который принимает массив элементов, помещает их в очередь и выводит на консоль содержимое очереди.
 */
public class Task3 {
    public static void run(){
    int[] arr = createArray(5, 0, 100);
    System.out.println("+++ Исходный массив +++\n" + Arrays.toString(arr));
        System.out.println("+++ LIFO +++");
        printLIFO(arr);
        System.out.println("+++ FIFO +++");
        printFIFO(arr);
    }
    private static void printLIFO(int[] arr){
        Stack<Integer> stack = new Stack<>();
        for (int i:arr) {
            stack.push(i);
        }
        while (!stack.empty()){
            System.out.println(stack.pop());
        }
    }
    private static void printFIFO(int[] arr){
        Queue<Integer> queue = new LinkedList<>();
        for (int i:arr) {
            queue.add(i);
        }
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }

    private static int[] createArray(int size, int origin, int bound) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(origin, bound);
        }
        return arr;
    }
}
