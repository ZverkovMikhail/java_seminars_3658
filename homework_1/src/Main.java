/**
 * Написать программу вычисления n-ого треугольного числа
 */

public class Main {
    public static void main(String[] args) {
        int num = Lib.getNumberByUser();
        System.out.println(triangle(num));
    }

    /**
     * Возвращает n-е треугольное число
     */
    static int triangle(int n) {
        if (n == 1)
            return 1;
        else
            return (n + triangle(n - 1));
    }
}