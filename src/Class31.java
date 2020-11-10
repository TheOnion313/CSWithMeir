import DS.Queue;
import DS.Stack;

public class Class31 {

    public static int isZigLenQ(Queue<Character> que) {
        int count = 1;
        if (que.isEmpty()) return 0;
        int prev = 0;
        while (!que.isEmpty() && que.head() != '#') {
            prev++;
            que.remove();
        }
        if (que.isEmpty()) {
            return count;
        } else {
            que.remove();
        }

        while (!que.isEmpty()) {
            int c = 0;
            while (!que.isEmpty() && que.head() != '#') {
                c++;
                que.remove();
            }
            count++;
            if (c > prev) {
                return 0;
            }

            if (que.isEmpty()) {
                return count;
            } else {
                que.remove();
            }

            prev = c;
            c = 0;


            while (!que.isEmpty() && que.head() != '#') {
                c++;
                que.remove();
            }
            if (c < prev) return 0;
            count++;

            if (que.isEmpty()) {
                return count;
            } else {
                que.remove();
            }
            prev = c;
        }

        return count;
    }

    public static int isZigLenStk(Stack<Character> st) {
        int count = 1;
        if (st.isEmpty()) return 0;
        int prev = 0;
        while (!st.isEmpty() && st.top() != '#') {
            prev++;
            st.pop();
        }
        if (st.isEmpty()) {
            return count;
        } else {
            st.pop();
        }

        while (!st.isEmpty()) {
            int c = 0;
            while (!st.isEmpty() && st.top() != '#') {
                c++;
                st.pop();
            }
            count++;
            if (c > prev) {
                return 0;
            }

            if (st.isEmpty()) {
                return count;
            } else {
                st.pop();
            }

            prev = c;
            c = 0;


            while (!st.isEmpty() && st.top() != '#') {
                c++;
                st.pop();
            }
            if (c < prev) return 0;
            count++;

            if (st.isEmpty()) {
                return count;
            } else {
                st.pop();
            }
            prev = c;
        }

        return count;
    }


    public static void main(String[] args) {
        Stack<Character> s = new Stack<>();
        s.push('1');
        s.push('2');
        s.push('#');
        s.push('1');
        s.push('1');
        s.push('1');
        s.push('#');
        s.push('1');
        s.push('1');
        s.push('#');
        s.push('1');
        s.push('1');
        s.push('1');
        s.push('1');
        System.out.println(isZigLenStk(s));
    }
}
