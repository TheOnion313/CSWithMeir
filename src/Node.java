public class Node<T> {
    private T val;
    private Node<T> next;

    public Node(T val, Node<T> next) {
        this.val = val;
        this.next = next;
    }

    public Node(T val) {
        this.val = val;
        this.next = null;
    }

    public Node(Node<T> n) {
        this.val = n.getVal();
        this.next = n.getNext();
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", next=" + (next == null ? "null" : next.toString()) +
                '}';
    }
}
