import DS.Node;

public class ExampleDSQ {

    public static int chainToNum(Node<Integer> lst) {
        if(lst == null) return -1;
        int mul = 1;
        int ret = 0;
        Node<Integer> cur = lst;

        while(cur != null) {
            ret += cur.getValue() * mul;
            mul *= 10;

            cur = cur.getNext();
        }

        return ret;
    }

    public static int maxInList(Node<Node<Integer>> lst) {
        int max = -1;
        Node<Node<Integer>> cur = lst;
        while(cur != null) {
            if(chainToNum(cur.getValue()) > max) max = chainToNum(cur.getValue());

            cur = cur.getNext();
        }

        return max;
    }

    /*
    complexity:
    define n as the chain length
    define m as the average chain length of each subchain.
    m and n are not limited.

    the function iterates over the main chain once, n times.
    in each iteration it calls chainToNum which iterates over the subchain once, m times.

    therefore: the function iterates n*m times
    O(n*m)
     */
}
