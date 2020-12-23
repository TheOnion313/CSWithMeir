import DS.Node;
import basics.Point;

public class Class34 {

    public static Point4D random4D(int lo, int hi) {
        return new Point4D(random(lo, hi), random(lo, hi), random(lo, hi), random(lo, hi));
    }

    public static int random(int lo, int hi) {
        return (int) (Math.random() * (hi - lo + 1)) + lo;
    }

    public static Node<Point4D> shape(int size, int lo, int hi) {
        assert size >= 0;
        if(size == 0) {
            return null;
        }
        Node<Point4D> head = new Node<Point4D>(random4D(lo, hi));
        int count = 1;

        Node<Point4D> cur = head;
        while (count < size) {
            cur.setNext(new Node<Point4D>(random4D(lo, hi)));
            cur = cur.getNext();
            count++;
        }

        return head;
    }

    public static Node<Point4D> shapeR(int size, int lo, int hi) {
        if(size == 1) {
            return new Node<Point4D>(random4D(lo, hi));
        } else {
            return new Node<>(random4D(lo, hi), shapeR(size - 1, lo, hi));
        }
    }
}
