import DS.Node;

public class Class35 {

    public static <T> boolean inChain(Node<T> lst, Node<T> val) {
        Node<T> cur = lst;
        while (cur.hasNext()) {
            if (cur == val) return false;
            if (val.getNext() == cur) return true;
            cur = cur.getNext();
        }

        return false;
    }

    static class isLoopRet<T> {
        public Node<T> lst;
        public boolean ret;

        public isLoopRet(Node<T> lst, boolean ret) {
            this.lst = lst;
            this.ret = ret;
        }
    }


    public static <T> isLoopRet<T> isLoopOn(Node<T> lst) {
        Node<T> postcard = new Node<>(lst.getValue()); // arbitrary value to create postcard node, needs value
        Node<T> copy = new Node<>(lst.getValue());
        Node<T> app = copy;
        Node<T> cur = lst;
        boolean ret = false;
        while (cur.hasNext()) {
            if (cur.getNext() == postcard) ret = true;
            Node<T> tmp = cur.getNext();
            cur.setNext(postcard);
            cur = tmp;

            app.setNext(new Node<>(cur.getValue()));
            app = app.getNext();
        }
        return new isLoopRet<T>(copy, ret);

    }

    public static <T> boolean isLoopOn2(Node<T> lst) {
        Node<T> cur = lst;
        while (cur.hasNext()) {
            if (inChain(lst, cur)) return true;
            cur = cur.getNext();
        }
        return false;
    }

    public static void checkLoop() {
        System.out.println("Complexity O(n^2):\n");
        //loop
        Node<Integer> n1 = new Node<>(4);
        Node<Integer> n2 = new Node<>(3, n1);
        Node<Integer> n3 = new Node<>(2, n2);
        Node<Integer> n4 = new Node<>(1, n3);
        n1.setNext(n4);
        System.out.println("Should be true: " + isLoopOn2(n4));

        //middle chain
        n1.setNext(n3);
        System.out.println("Should be true AW: " + isLoopOn2(n4));
        //loop

        //no longer loop
        n1.setNext(null);
        System.out.println("Should be false: " + isLoopOn2(n4));

        System.out.println("Complexity O(n):\n");
        n1 = new Node<>(4);
        n2 = new Node<>(3, n1);
        n3 = new Node<>(2, n2);
        n4 = new Node<>(1, n3);
        n1.setNext(n4);
        isLoopRet<Integer> ret = isLoopOn(n4);
        n4 = ret.lst;
        System.out.println("Should be true: " + ret.ret);

        n4.getNext().getNext().getNext().setNext(n4.getNext());
        ret = isLoopOn(n4);
        n4 = ret.lst;
        System.out.println("Should be true AW: " + ret.ret);
        //loop

        n4.getNext().getNext().getNext().setNext(null);
        ret = isLoopOn(n4);
        System.out.println("Should be false: " + ret.ret);
    }

    public static void main(String[] args) {
        checkLoop();
    }
}
