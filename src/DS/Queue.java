package DS;

public class Queue<T> {
    private Node<T> first = null;
    private Node<T> last = null;

    public Queue() {
    }

    public Queue(Queue<T> q) {
        this.first = new Node<>(q.first.getValue(), q.first.getNext());
        this.last = new Node<>(q.last.getValue(), q.last.getNext());
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public void insert(T x) {
        Node<T> k = new Node<>(x);
        if (this.first == null) {
            this.first = k;
            this.last = this.first;
        } else {
            this.last.setNext(k);
            this.last = this.last.getNext();
        }

    }

    public T remove() {
        T x = this.first.getValue();
        this.first = this.first.getNext();
        return x;
    }

    public T head() {
        return this.first.getValue();
    }

    public String toString() {
        if (this.isEmpty()) {
            return "[]";
        } else {
            this.insert((T)null);
            String s = "[";

            for(T temp = this.remove(); temp != null; temp = this.remove()) {
                s += temp.toString() + ",";
                this.insert(temp);
            }

            s = s.substring(0, s.length() - 1) + "]";
            return s;
        }
    }
}