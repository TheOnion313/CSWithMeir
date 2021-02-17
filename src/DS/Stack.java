package DS;

public class Stack<T> {
    private Node<T> first = null;

    public Stack() {
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public void push(T x) {
        Node<T> temp = new Node(x);
        temp.setNext(this.first);
        this.first = temp;
    }

    public T pop() {
        T x = this.first.getValue();
        this.first = this.first.getNext();
        return x;
    }

    public T top() {
        T x = this.first.getValue();
        return x;
    }

    public String toString() {
        String str = "[";

        for(Node pos = this.first; pos != null; pos = pos.getNext()) {
            str = str + pos.getValue().toString();
            if (pos.getNext() != null) {
                str = str + ",";
            }
        }

        str = str + "]";
        return str;
    }
}