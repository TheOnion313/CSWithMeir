package DS;

public class NodeInt {
    private int value;
    private NodeInt next;

    public NodeInt(int value) {
        this.value = value;
        this.next = null;
    }

    public NodeInt(int value, NodeInt next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return this.value;
    }

    public NodeInt getNext() {
        return this.next;
    }

    public boolean hasNext() {
        return this.next != null;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(NodeInt next) {
        this.next = next;
    }

    public String ToString() {
        return this.next != null ? this.value + "-->" : this.value + "-->";
    }
}