package DS;

public class BinNode<T> {
    private BinNode<T> left;
    private T value;
    private BinNode<T> right;

    public BinNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public BinNode(BinNode<T> left, T value, BinNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return this.value;
    }

    public BinNode<T> getLeft() {
        return this.left;
    }

    public void setLeft(BinNode<T> left) {
        this.left = left;
    }

    public boolean hasLeft() {
        return this.left != null;
    }

    public BinNode<T> getRight() {
        return this.right;
    }

    public void setRight(BinNode<T> right) {
        this.right = right;
    }

    public boolean hasRight() {
        return this.right != null;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String toString() {
        return "<-" + this.value + "->";
    }
}