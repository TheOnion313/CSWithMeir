import DS.Stack;

public class Queue<T> {
    private Stack<T> values;

    public Queue(Stack<T> values) {
        this.values = new Stack<>();
        Stack<T> tmp = new Stack<>();
        while (!values.isEmpty()) {
            tmp.push(values.pop());
        }
        while (!tmp.isEmpty()) {
            this.values.push(tmp.top());
            values.push(tmp.pop());
        }
    }

    public void insert(T value) {
        Stack<T> tmp = new Stack<>();
        while (!this.values.isEmpty()) {
            tmp.push(this.values.pop());
        }
        tmp.push(value);
        while (!tmp.isEmpty()) {
            this.values.push(tmp.pop());
        }

    }

    public T remove() {
        Stack<T> tmp = new Stack<>();
        while (!this.values.isEmpty()) {
            tmp.push(this.values.pop());
        }
        T ret = tmp.pop();
        while (!tmp.isEmpty()) {
            this.values.push(tmp.pop());
        }
        return ret;

    }

    public T head() {
        Stack<T> tmp = new Stack<>();
        while (!this.values.isEmpty()) {
            tmp.push(this.values.pop());
        }
        T ret = tmp.top();
        while (!tmp.isEmpty()) {
            this.values.push(tmp.pop());
        }
        return ret;
    }

    public Stack<T> getStk() {
        return this.values;
    }

    public static void moveQ(Queue<Integer> fr, Queue<Integer> to) {
        Stack<Integer> tmp = new Stack<>();
        while (!fr.getStk().isEmpty()) {
            tmp.push(fr.getStk().pop());
        }

        while (!tmp.isEmpty()) {
            fr.getStk().push(tmp.top());
            to.getStk().push(tmp.pop());
        }
    }

    public static Queue<Integer> copyQ(Queue<Integer> fr) {
        Stack<Integer> tmp = new Stack<>();
        while (!fr.getStk().isEmpty()) {
            tmp.push(fr.getStk().pop());
        }
        Stack<Integer> copy = new Stack<>();
        while (!tmp.isEmpty()) {
            copy.push(tmp.top());
            fr.getStk().push(tmp.pop());
        }
        return new Queue<Integer>(copy);
    }

    public static int occInQue(Queue<Integer> qu, Integer val) {
        Stack<Integer> tmp = new Stack<>();
        int cnt = 0;
        while (!qu.getStk().isEmpty()) {
            if(qu.getStk().top().equals(val)) cnt++;
            tmp.push(qu.getStk().pop());
        }
        while (!tmp.isEmpty()) {
            qu.getStk().push(tmp.pop());
        }

        return cnt;
    }

    public static boolean inQue(Queue<Integer> qu, Integer val) {
        return occInQue(qu, val) > 0;
    }
    
}
