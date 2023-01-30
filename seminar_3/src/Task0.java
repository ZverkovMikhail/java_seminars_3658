/**
 * Даны следующие строки, cравнить их с помощью == и метода equals() класса Object
 * String s1 = "hello";
 * String s2 = "hello";
 * String s3 = s1;
 * String s4 = "h" + "e" + "l" + "l" + "o";
 * String s5 = new String("hello");
 * String s6 = new String(new char[]{'h', 'e', 'l', 'l', 'o'});
 */
public class Task0 {
    public static void run() {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = s1;
        String s4 = "h" + "e" + "l" + "l" + "o";
        String s5 = new String("hello");
        String s6 = new String(new char[]{'h', 'e', 'l', 'l', 'o'});
        strCompare(s1, s2);
        strCompare(s1, s3);
        strCompare(s1, s4);
        strCompare(s1, s5);
        strCompare(s1, s6);
    }

    public static void strCompare(String str1, String str2) {
        System.out.println("str1.equals(str2) = " + str1.equals(str2));
        System.out.println("str1 == str2 = " + (str1 == str2));
    }
}
