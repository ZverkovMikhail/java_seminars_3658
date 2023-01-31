import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex005 {

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // (1+2*3*4)*(10/5) - 20
        // 1 2 3 * 4 * + 10 5 / * 20 -
        String reg = "\\((.+)*?\\)";
        String[] vals = "(20-30)*10".split(reg);

        Pattern pattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("(20-30)*10");
        while (matcher.find()){
            for (int i = 0; i < matcher.groupCount(); i++) {

                System.out.printf("vals in group # %s = %s\n",  i,  matcher.group(i));
            }
        }

        var exp = "20 30 - 10 *".split(" "); // (20-30)*10
//        var exp = "1 2 + 3 *".split(" "); // (1 + 2) * 3
//        var exp = "2  3 ^ 1 +".split(" "); // 2^3+1

        //var exp = "1 2 3 * +".split(" "); // 1 + 2 * 3
        int res = 0;
        System.out.println(Arrays.toString(exp));

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < exp.length; i++) {

            if (isDigit(exp[i])) {
                st.push(Integer.parseInt(exp[i]));
            } else {
                switch (exp[i]) {
                    case "+":
                        res = st.pop() + st.pop();
                        st.push(res);
                        break;
                    case "-":
                        res = -st.pop() + st.pop();
                        st.push(res);
                        break;
                    case "*":
                        res = st.pop() * st.pop();
                        st.push(res);
                        break;
                    case "/":
                        res = st.pop() / st.pop();
                        st.push(res);
                        break;
                    case "^":
                        int powVal = st.pop();
                        int val = st.pop();
                        System.out.println("powVal = " + powVal);
                        System.out.println("val = " + val);
                        res = (int)Math.pow(val, powVal);
                        st.push(res);
                        break;
                    default:
                        break;
                }
            }
        }
        System.out.printf("%d\n", st.pop());
    }
}