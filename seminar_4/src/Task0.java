import java.util.*;

/**
 * 1) Замерьте время, за которое в ArrayList добавятся 10000 элементов.
 * 2) Замерьте время, за которое в LinkedList добавятся 10000 элементов. Сравните с предыдущим.
 */
public class Task0 {
    public static void run(){
        int size = 1000000;
        TimeCounter tc = new TimeCounter();
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new PriorityQueue<>();
        Integer[] arr = new Integer[size];



        tc.start("LinkedList");
        for(Integer i = 0; i < size; i++){
            linkedList.add(i);
        }
        tc.stopAndPrint();
        tc.start("Stack");
        for(Integer i = 0; i < size; i++){
            stack.add(i);
        }
        tc.stopAndPrint();
        tc.start("Queue");
        for(Integer i = 0; i < size; i++){
            queue.add(i);
        }
        tc.stopAndPrint();
        tc.start("Array");
        for(Integer i = 0; i < size; i++){
            arr[i] = i;
        }
        tc.stopAndPrint();
        tc.start("ArrayList");
        for(Integer i = 0; i < size; i++){
            arrayList.add(i);
        }
        tc.stopAndPrint();
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