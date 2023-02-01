import java.util.LinkedList;
import java.util.List;

/**
 *  Реализуйте очередь с помощью LinkedList со следующими методами:
 *  enqueue() - помещает элемент в конец очереди,
 *  dequeue() - возвращает первый элемент из очереди и удаляет его,
 *  first() - возвращает первый элемент из очереди, не удаляя.
 */
public class Task2 {
    static List<Integer> list = new LinkedList<>();
    public static void run(){
        for (int i = 0; i < 10; i++) {
            enqueue(i);
        }
        System.out.println(dequeue());
        System.out.println(first());
        System.out.println(dequeue());
        System.out.println(list);
    }
    public static void enqueue(int elem){
        list.add(elem);
    }
    public static int dequeue(){
        int temp = list.get(0);
        list.remove(0);
        return temp;
    }
    public static int first(){
        return list.get(0);
    }

}
