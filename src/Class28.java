import DS.*;

public class Class28 {

    public static Stack<Integer> Stack(Stack<Integer> st) {
        Stack<Integer> tmp = new Stack<>();

        while (!st.isEmpty()) {
            tmp.push(st.pop());
        }

        Stack<Integer> ret = new Stack<>();

        while (!st.isEmpty()) {
            ret.push(tmp.top());
            st.push(tmp.pop());
        }

        return ret;

    }

    public static void moveSt(Stack<Integer> fr, Stack<Integer> to) {
        while(!fr.isEmpty()) {
            to.push(fr.pop());
        }
    }

    public static int findMinStk(Stack<Integer> st) {
        Stack<Integer> tmp = Stack(st);
        int min = tmp.pop();
        while(!tmp.isEmpty()) {
            if(tmp.top() < min) {
                min = tmp.pop();
            } else {
                tmp.pop();
            }
        }
        return min;
    }


    public static boolean isEqual(Stack<Integer> st1, Stack<Integer> st2) {
        while(!(st1.isEmpty() || st2.isEmpty())) {
            if(!st1.pop().equals(st2.pop())) { return false; }
            if((st1.isEmpty() && !st2.isEmpty()) || (st2.isEmpty() && !st1.isEmpty())) { return false; }
        }

        return true;
    }

    public static int sumStk(Stack<Integer> st) {
        int sum = 0;
        Stack<Integer> tmp = Stack(st);

        while(!tmp.isEmpty()) {
            sum += tmp.pop();
        }

        return sum;
    }

    public static void main(String[] args) {
        Stack<Integer> a = new Stack<>(), b = new Stack<>();
        for (int i = 0; i < 15; i++) {
            a.push(i);
        }
        System.out.println(a);
        moveSt(a, b);
        System.out.println(b);
    }
}
