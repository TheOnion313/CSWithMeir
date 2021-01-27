import DS.Node;

public class Class35_2 {

    public static <T> boolean isLoopOn(Node<T> lst) {
        Node<T> postcard = new Node<>(null); // value doesn't matter since we're comparing memory, not value
        int count = 0;
        int len = 0;

        while(lst.hasNext()) {
            len++;
            count++;
            if(lst.getNext().getNext() == postcard) {
                System.out.print(String.format("Iterations: %d\t", count));
                System.out.print(String.format("Len: %d", len));
                return true;
            }
            Node<T> tmp = lst.getNext();
            lst.setNext(postcard);

            lst = tmp;
        }
        System.out.print(String.format("Iterations: %d\t", count));
        System.out.print(String.format("Len: %d", len));
        return false;
    }

    public static <T> boolean isLoopOn2(Node<T> lst) {
        Node<T> cur = lst;
        int count = 0;
        int len = 0;
        while (cur.hasNext()) {
            len++;
            count++;
            Node<T> curInner = lst;
            while (curInner != cur) {
                count++;
                if (curInner == cur.getNext()) {
                    System.out.print(String.format("Iterations: %d\t", count));
                    System.out.print(String.format("Len: %d", len));
                    return true;
                }
                curInner = curInner.getNext();
            }
            cur = cur.getNext();
        }
        len++;
        System.out.print(String.format("Iterations: %d\t", count));
        System.out.print(String.format("Len: %d", len));

        return false;
    }

    public static <T> Node<T> copy(Node<T> lst) {
        if (!lst.hasNext()) {
            return new Node<>(lst.getValue());
        }
        return new Node<>(lst.getValue(), copy(lst.getNext()));
    }

    public static int random(int lo, int hi) {
        return (int) (Math.random() * (hi - lo + 1)) + lo;
    }

    public static Node<Integer> gen100() {
        Node<Integer> ret = new Node<>(random(0, 80));
        Node<Integer> app = ret;
        for (int i = 0; i < 99; i++) {
            app.setNext(new Node<>(random(0, 80)));
            app = app.getNext();
        }

        return ret;
    }

    public static void resetLoop(Node<Integer> lst, Node<Integer> last) {
        //assuming the chain length is 100 (as set in the gen100 function
        int nodeId = random(20, 80);
        Node<Integer> cur = lst;
        for (int i = 0; i < nodeId; i++) {
            cur = cur.getNext();
        }

        last.setNext(cur);
    }

    public static <T> Node<T> getLast(Node<T> lst) {
        //assuming the chain is not looped
        while (lst.hasNext()) {
            lst = lst.getNext();
        }
        return lst;
    }

    public static void main(String[] args) {
        Node<Integer> test = gen100(), last = getLast(test);
        System.out.println("O(n) check:");
        for (int i = 0; i < 100; i++) {
            Node<Integer> copy = copy(test);
            resetLoop(copy, getLast(copy));
            System.out.println(String.format("\tLoop: %b", isLoopOn(copy)));
        }

        resetLoop(test, last);
        System.out.println("\nO(n^2) check:");
        for (int i = 0; i < 100; i++) {
            System.out.println(String.format("\tLoop: %b", isLoopOn2(test)));
            resetLoop(test, last);
        }

    }
}
