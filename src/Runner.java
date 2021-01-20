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
        IstItems = r.getIstItems();
    }


    public String getId() {
        return id;
    }

    public int getYearB() {
        return yearB;
    }

    public Node<Item> getIstItems() {
	if(IstItems == null) return null;

	Node<Item> ret = new Node<>(new Runner(IstItems.getValue())); // copy chain
	Node<Item> app = ret; // ret chain tail
	Node<Item> cur = IstItems.getNext(); // cycle node
	while(cur != null) { // until finished last node
		app.setNext(new Node<Item>(new Runner(cur.getValue()))); // append to tail
		app = app.getNext(); // update tail
		
		cur = cur.getNext(); // next node cycle
	}

        return ret;
    }

    public void addMrtn(Item i) {
        Node<Item> cur = IstItems; // cycle node
        while (cur.hasNext()) { // get last node
            cur = cur.getNext();
        }
	cur.setNext(new Node<Item>(new Item(i))); // append new Item to chain
    }

    public boolean ran3InARow() {
        Node<Item> cur = IstItems; // cycle node
        while (cur != null && cur.hasNext() && cur.getNext().hasNext()) { // if node does not have next marathon since chain is sorted this node cannot have 2 marathons directly after it in a row for this runner
            if (cur.getValue().getYear() == cur.getNext().getValue().getYear() - 1 && cur.getNext().getValue().getYear() == cur.getNext().getNext().getValue().getYear() - 1) { // if this node contains the first marathon out of 3 in a row
		    // checks if the next marathon in sorted chain's year is one year higher, therefore in a row
                return true; // there are 3 in a row
            }
        }

        return false; // checked all nodes, none are 3 in a row, return false
    }
}
