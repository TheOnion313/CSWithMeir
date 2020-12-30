import DS.Node;

import java.util.Arrays;

public class Runner {
    private String id;
    private int yearB;
    private Node<Item> IstItems;

    @Override
    public String toString() {
        return "Runner{" +
                "id='" + id + '\'' +
                ", yearB=" + yearB +
                ", IstItems=" + IstItems +
                '}';
    }

    public Runner(String id, int yearB, Node<Item> istItems) {
        this.id = id;
        this.yearB = yearB;
        this.IstItems = istItems;
    }

    public Runner(Runner r) {
        id = r.getId();
        yearB = r.getYearB();
        IstItems = r.getIstRunners();
    }


    public String getId() {
        return id;
    }

    public int getYearB() {
        return yearB;
    }

    public Node<Item> getIstRunners() {
        return IstItems;
    }

    public void addMrtn(Item i) {
        Node<Item> cur = IstItems;
        while (cur.hasNext()) {
            if (cur.getNext().getValue().getYear() > i.getYear()) {
                Node<Item> temp = cur.getNext();
                cur.setNext(new Node<Item>(i, temp));
                return;
            }
            cur = cur.getNext();
        }
    }

    public boolean ran3InARow() {
        Node<Item> cur = IstItems;
        while (cur != null && cur.hasNext() && cur.getNext().hasNext()) {
            if (cur.getValue().getYear() == cur.getNext().getValue().getYear() - 1 && cur.getNext().getValue().getYear() == cur.getNext().getNext().getValue().getYear() - 1) {
                return true;
            }
        }

        return false;
    }
}
