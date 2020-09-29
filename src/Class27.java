import DS.*;

public class Class27 {

    public static Stack<Integer> Stack(Stack<Integer> st) {
        Stack<Integer> tmp = new Stack<>();

        while (!st.isEmpty()) {
            tmp.push(st.pop());
        }

        Stack<Integer> ret = new Stack<>();

        while (!st.isEmpty()) {
            ret.push(tmp.pop());
        }

        return ret;

    }

    public static int stLen(Stack<Integer> st) {
        Stack<Integer> tmp = Stack(st);
        int len = 0;

        while (!tmp.isEmpty()) {
            tmp.pop();
            len++;
        }

        return len;
    }

    public static boolean isFound(int val, Stack<Integer> st) {
        Stack<Integer> tmp = Stack(st);

        while (!tmp.isEmpty()) {
            if (tmp.pop() == val) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
