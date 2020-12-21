import DS.Node;

public class Ass21_12_2020 {

    public static String strLst(Node<Integer> p) {

        if (p.hasNext()) {
            return p.getValue().toString() + " -> " + strLst(p.getNext()); // recursively connect the value of the current node with the str of the rest of the chain
        }
        return p.getValue().toString(); // exit condition: last node returns without recursion

    }

    public static Node<Integer> remove(Node<Integer> lst, Node<Integer> pt) {
        if (pt == lst) { // if you want to remove the first node, you return the second one
            return lst.getNext();
        }
        Node<Integer> copy = lst; // save the head
        Node<Integer> cur = lst; // start going through the chain

        while (cur.getNext() != pt) { // find the node before the node to remove
            cur = cur.getNext(); // next node
        }

        cur.setNext(cur.getNext().getNext()); // take node prior to remove node and connect it to the removed node's next node, by that excluding it from the chain

        return copy; // return copy of the chain's head
    }

    public static Node<Integer> findMinP(Node<Integer> head) {
        Node<Integer> min = head; // minimum value node
        Node<Integer> cur = head; // temporary node to cycle through the chain

        while (cur != null) { // until last node
            if (cur.getValue() < min.getValue()) { // whenever a node with a lower value is found set new minimum node
                min = cur;
            }
            cur = cur.getNext(); // next node
        }

        return min; // return minimum value node
    }

    public static int findMinV(Node<Integer> head) {
        int min = head.getValue(); // initial arbitrary value from the chain
        Node<Integer> cur = head; // temporary node to cycle through chain

        while (cur != null) { // until last node
            if (cur.getValue() < min) { // if found lower value in chain set new minimum
                min = cur.getValue();
            }
            cur = cur.getNext(); // next node
        }

        return min; // return minimum value
    }

    public static Node<Integer> sort(Node<Integer> lst) {
        Node<Integer> ret = findMinP(lst); // start by setting the head of the chain as the minimum node
        lst = remove(lst, findMinP(lst)); // remove node from chain

        Node<Integer> cur = ret; // temporary node to cycle through chain

        while (lst != null) { // until removed all nodes, therefore sorted them all in the new sorted chain
            cur.setNext(findMinP(lst)); // insert next node in chain as the minimum node in the remaining nodes from lst
            lst = remove(lst, findMinP(lst)); // remove node from lst
            cur = cur.getNext(); // cycle to next node in sorted chain
        }

        return ret; // return new head of sorted chain
    }

    public static Node<Integer> mergeSorted(Node<Integer> lst1, Node<Integer> lst2) {
        Node<Integer> ret, head;

        if (lst1.getValue() < lst2.getValue()) {
            ret = lst1;
            head = lst1;
            lst1 = lst1.getNext();
        } else {
            ret = lst2;
            head = lst2;
            lst2 = lst2.getNext();
        }

        while (lst2 != null || lst1 != null) {
            if (lst2 == null) {
                ret.setNext(lst1);
                lst1 = lst1.getNext();
            } else if (lst1 == null) {
                ret.setNext(lst2);
                lst2 = lst2.getNext();
            } else if (lst1.getValue() < findMinV(lst2)) {
                ret.setNext(lst1);
                lst1 = lst1.getNext();
            } else {
                ret.setNext(lst2);
                lst2 = lst2.getNext();
            }

            ret = ret.getNext();
        }

        return head;
    }

    public static void main(String[] args) {
        Node<Integer> n0 = new Node<>(3);
        Node<Integer> n1 = new Node<>(2, n0);
        Node<Integer> n2 = new Node<>(9, n1);
        Node<Integer> n3 = new Node<>(6, n2);

        System.out.println("Before sort: " + strLst(n3));
        Node<Integer> sorted = sort(n3);
        System.out.println("After sort: " + strLst(sorted) + "\n");

        Node<Integer> n4 = new Node<>(10);
        Node<Integer> n5 = new Node<>(9, n4);
        Node<Integer> n6 = new Node<>(5, n5);
        Node<Integer> n7 = new Node<>(1, n6);

        System.out.println("Second chain: " + strLst(n7));
        Node<Integer> merge = mergeSorted(n7, sorted);

        System.out.println("Sorted merge: " + strLst(merge));

    }

}
