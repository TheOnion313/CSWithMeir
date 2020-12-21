import DS.Node;

public class Class32 {

    public static <T> String strLst(Node<T> p) {
        assert p != null;

        if (p.hasNext()) {
            return p.getValue().toString() + " -> " + strLst(p.getNext());
        }
        return p.getValue().toString();
    }

    public static <T> int lstSize(Node<T> p) {
        Node<T> cur = p;
        int len = 1;
        while (cur.hasNext()) {
            len++;
            cur = cur.getNext();
        }
        return len;
    }

    public static <T> int lstSizeR(Node<T> p) {
        if (p.hasNext()) {
            return 1 + lstSizeR(p.getNext());
        }
        return 1;
    }

    public static Node<Integer> lstGen(int size, int hi, int lo) {
        if (size == 0) return null;
        return new Node<Integer>(lo + (int)(Math.random() * (hi - lo + 1)), lstGen(size - 1, hi, lo));
    }

    public static Node<Integer> getIt(Node<Integer> lst, int val) {
        if(lst.getValue() == val) return lst;
        if(!lst.hasNext()) return null;
        return getIt(lst.getNext(), val);
    }

    public static <T> void insertAfter(Node<T> aft, Node<T> lst) {
        Node<T> tmp = lst.getNext();
        lst.setNext(aft);
        Node<T> cur = aft;
        while(cur.hasNext()) {
            cur = cur.getNext();
        }
        cur.setNext(tmp);
    }

    public static <T> boolean inLst(Node<T> lst, T val) {
        if (lst == null) return false;
        return lst.getValue() == val || inLst(lst.getNext(), val);
    }

    public static void main(String[] args) {
        Node<Integer> third = new Node<>(1);
        Node<Integer> second = new Node<>(51, third);
        Node<Integer> first = new Node<>(6, second);
        System.out.println(strLst(first));
        System.out.println(lstSize(first));
        System.out.println(lstSizeR(first));
        Node<Integer> lst = lstGen(900, 420, 69);
        System.out.println(strLst(lst));
        System.out.println(strLst(getIt(lst, 70)));
    }
}
