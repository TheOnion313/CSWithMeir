import DS.BinNode;
import DS.Node;

public class Q6 {

    public static boolean exist(BinNode<Integer> t, int x) {
        /**
         * @returns whether value x is in this tree
         * @param t is the tree searching
         * @param x is the value checking if it's in tree t
         *
         * Complexity: let m be the amount of nodes in t
         * m is not restricted
         *
         * The function iterates recursively over all nodes of the tree and checks
         * Therefore: O(m)
         */
        if (!(t.hasLeft() || t.hasRight())) return false;
        boolean l = false, r = false;

        if (t.hasLeft()) {
            l = exist(t.getLeft(), x);
        }
        if (t.hasRight()) {
            r = exist(t.getRight(), x);
        }

        return l || r || t.getValue() == x;
    }

    public static Node<Integer> check(BinNode<Integer> t1, BinNode<Integer> t2, Node<Integer> first) {
        /**
         * @returns all the values that are in t1 but aren't in t2 as a LinkedList
         * @param t1 is the tree that we want to include all it's values
         * @param t2 is the tree that we want to exclude all it's values
         * @param first is the LinkedList we add the values to
         * Complexity: let n be the amount of nodes in t1, let m be the amount of nodes in t2
         * n and m are not restricted
         *
         * The function goes over all nodes once, for each one it calls exist once
         * Therefore: O(n*m) ג
         */
        if (t1 == null) return first;
        if (!exist(t2, t1.getValue())) {
            if (!first.hasNext()) {
                first.setNext(new Node<Integer>(t1.getValue()));
            } else {
                Node<Integer> tmp = first.getNext();
                first.setNext(new Node<>(t1.getValue(), tmp));
            }
        }
        check(t1.getLeft(), t2, first);
        check(t1.getRight(), t2, first);

        return first;
    }


}
