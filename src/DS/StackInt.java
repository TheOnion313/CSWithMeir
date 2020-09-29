package DS;

public class StackInt {
    private NodeInt first = null;

    public StackInt() {
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public void push(int x) {
        NodeInt temp = new NodeInt(x);
        temp.setNext(this.first);
        this.first = temp;
    }

    public int pop() {
        int x = this.first.getValue();
        this.first = this.first.getNext();
        return x;
    }

    public int top() {
        return this.first.getValue();
    }

    public String toString() {
        String str = "[";

        for(NodeInt pos = this.first; pos != null; pos = pos.getNext()) {
            str = str + pos.getValue();
            if (pos.getNext() != null) {
                str = str + ",";
            }
        }

        str = str + "]";
        return str;
    }
}